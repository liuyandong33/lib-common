package build.dream.common;

import build.dream.common.constants.Constants;
import build.dream.common.utils.JacksonUtils;
import build.dream.common.utils.OkHttpUtils;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crawler {
    public static void main(String[] args) {
        /*//华北地区
        obtainProvinceData("11", "北京市");
        obtainProvinceData("12", "天津市");
        obtainProvinceData("13", "河北省");
        obtainProvinceData("14", "山西省");
        obtainProvinceData("15", "内蒙古自治区");

        // 东北地区
        obtainProvinceData("21", "辽宁省");
        obtainProvinceData("22", "吉林省");
        obtainProvinceData("23", "黑龙江省");

        // 华东地区
        obtainProvinceData("31", "上海市");
        obtainProvinceData("32", "江苏省");
        obtainProvinceData("33", "浙江省");
        obtainProvinceData("34", "安徽省");
        obtainProvinceData("35", "福建省");
        obtainProvinceData("36", "江西省");
        obtainProvinceData("37", "山东省");

        // 中南地区
        obtainProvinceData("41", "河南省");
        obtainProvinceData("42", "湖北省");
        obtainProvinceData("43", "湖南省");
        obtainProvinceData("44", "广东省");
        obtainProvinceData("45", "广西壮族自治区");
        obtainProvinceData("46", "海南省");

        // 西南地区
        obtainProvinceData("50", "重庆市");
        obtainProvinceData("51", "四川省");
        obtainProvinceData("52", "贵州省");
        obtainProvinceData("53", "云南省");
        obtainProvinceData("54", "西藏自治区");

        // 西北地区
        obtainProvinceData("61", "陕西省");
        obtainProvinceData("62", "甘肃省");
        obtainProvinceData("63", "青海省");
        obtainProvinceData("64", "宁夏回族自治区");
        obtainProvinceData("65", "新疆维吾尔自治区");*/

        obtainIpAddresses();
    }

    public static void obtainIpAddresses() {
        try {
            Document document = Jsoup.parse(new URL("http://ip.yqie.com/cn/shandong/qingdao/"), 600000);

            Elements elements = document.getElementsByTag("tbody").get(0).getElementsByTag("tr");
            for (int index = 1; index < elements.size(); index++) {
                Element element = elements.get(index);
                Elements tdElements = element.getElementsByTag("td");
                String startIp = tdElements.get(1).text();
                String endIp = tdElements.get(2).text();

                String[] startArray = startIp.split("\\.");
                long start = (Long.parseLong(startArray[0]) << 24) | (Long.parseLong(startArray[1]) << 16) | (Long.parseLong(startArray[2]) << 8) | (Long.parseLong(startArray[3]));

                String[] endArray = endIp.split("\\.");
                long end = (Long.parseLong(endArray[0]) << 24) | (Long.parseLong(endArray[1]) << 16) | (Long.parseLong(endArray[2]) << 8) | (Long.parseLong(endArray[3]));

                String address = tdElements.get(3).text();
                System.out.println(start + "-" + end + "," + address);
            }
        } catch (Exception e) {
            obtainIpAddresses();
        }
    }

    public static void obtainProvinceData(String provinceId, String provinceName) {
        String directoryPath = "/Users/liuyandong/Desktop/data";
        new Thread(() -> {
            List<Map<String, String>> list = getProvinceData(provinceId, provinceName);
            File file = new File(directoryPath + "/" + provinceName + ".json");
            try (OutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(JacksonUtils.writeValueAsString(list).getBytes(Constants.CHARSET_UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static List<Map<String, String>> getProvinceData(String provinceId, String provinceName) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", provinceId + "0000000000");
        map.put("name", provinceName);
        map.put("pid", "0");

        list.add(map);
        list.addAll(getCityData(provinceId + "0000000000", provinceId));
        return list;
    }

    public static List<Map<String, String>> getCityData(String pid, String provinceId) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> citys = getData(pid, provinceId + ".html");
        list.addAll(citys);
        for (Map<String, String> city : citys) {
            List<Map<String, String>> areas = getAreaData(city.get("id"), provinceId, city.get("id"));
            list.addAll(areas);
        }
        return list;
    }

    public static List<Map<String, String>> getAreaData(String pid, String provinceId, String cityId) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> areas = getData(pid, provinceId + "/" + cityId.substring(0, 4) + ".html");
        list.addAll(areas);

        for (Map<String, String> area : areas) {
            List<Map<String, String>> towns = getTownData(area.get("id"), provinceId, cityId, area.get("id"));
            list.addAll(towns);
        }
        return list;
    }

    public static List<Map<String, String>> getTownData(String pid, String provinceId, String cityId, String areaId) {
        String cityCode = cityId.substring(2, 4);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> towns = getData(pid, provinceId + "/" + cityCode + "/" + areaId.substring(0, 6) + ".html");
        list.addAll(towns);
        for (Map<String, String> town : towns) {
            list.addAll(getVillageData(town.get("id"), provinceId, cityId, areaId, town.get("id")));
        }
        return list;
    }

    public static List<Map<String, String>> getVillageData(String pid, String provinceId, String cityId, String areaId, String townId) {
        String areaCode = areaId.substring(4, 6);
        String cityCode = cityId.substring(2, 4);
        return getVillageData(pid, provinceId + "/" + cityCode + "/" + areaCode + "/" + townId.substring(0, 9) + ".html");
    }

    public static List<Map<String, String>> getData(String pid, String pageName) {
        try {
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + pageName;
            Document document = Jsoup.parse(new URL(url), 600000);
            document = handleGibberish(document, url, 1);
            Element element = document.getElementsByTag("tbody").get(4);
            Elements citytr = element.getElementsByTag("tr");
            for (int index = 1; index < citytr.size(); index++) {
                Element element1 = citytr.get(index);
                Elements elements = element1.getElementsByTag("td");
                Map<String, String> map = new HashMap<String, String>();
                map.put("pid", pid);
                map.put("id", elements.get(0).text());

                String name = elements.get(1).text();
                if (StringUtils.isNumeric(name)) {
                    name = elements.get(2).text();
                }

                map.put("name", name);
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            if (e instanceof HttpStatusException) {
                HttpStatusException httpStatusException = (HttpStatusException) e;
                if (httpStatusException.getStatusCode() == 404) {
                    return new ArrayList<Map<String, String>>();
                }
            }
            return getData(pid, pageName);
        }
    }

    public static List<Map<String, String>> getVillageData(String pid, String pageName) {
        try {
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + pageName;
            Document document = Jsoup.parse(new URL(url), 600000);
            document = handleGibberish(document, url, 2);
            Element element = document.getElementsByTag("tbody").get(4);
            Elements trElements = element.getElementsByTag("tr");
            for (int index = 1; index < trElements.size(); index++) {
                Elements elements = trElements.get(index).getElementsByTag("td");
                Map<String, String> map = new HashMap<String, String>();
                map.put("pid", pid);
                map.put("id", elements.get(0).text());

                String name = elements.get(1).text();
                if (StringUtils.isNumeric(name)) {
                    name = elements.get(2).text();
                }

                map.put("name", name);
                list.add(map);
            }
            System.out.println(JacksonUtils.writeValueAsString(list));
            return list;
        } catch (Exception e) {
            if (e instanceof HttpStatusException) {
                HttpStatusException httpStatusException = (HttpStatusException) e;
                if (httpStatusException.getStatusCode() == 404) {
                    return new ArrayList<Map<String, String>>();
                }
            }
            return getVillageData(pid, pageName);
        }
    }


    public static Document handleGibberish(Document document, String url, int nameIndex) {
        Response response = null;
        try {
            Element element = document.getElementsByTag("tbody").get(4);
            Elements trElements = element.getElementsByTag("tr");
            CharsetEncoder charsetEncoder = Constants.CHARSET_GBK.newEncoder();
            for (int index = 1; index < trElements.size(); index++) {
                Elements elements = trElements.get(index).getElementsByTag("td");
                String name = elements.get(nameIndex).text();
                if (!charsetEncoder.canEncode(name)) {
                    response = OkHttpUtils.doGetNative(url);
                    String result = new String(response.body().bytes(), Constants.CHARSET_GBK);
                    return Jsoup.parse(result);
                }
            }
            return document;
        } catch (Exception e) {
            return handleGibberish(document, url, nameIndex);
        } finally {
            OkHttpUtils.closeResponse(response);
        }
    }
}
