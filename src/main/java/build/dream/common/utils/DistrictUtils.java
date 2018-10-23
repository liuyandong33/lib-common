package build.dream.common.utils;

import org.apache.commons.collections.MapUtils;

import java.io.InputStream;
import java.util.*;

public class DistrictUtils {
    private static List<Map<String, String>> provinces = null;
    private static Map<String, Object> districtMap = null;
    private static List<Map<String, String>> districts = null;

    private static Map<String, Object> obtainDistrictMap() {
        if (districtMap == null) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("district.json");
            districtMap = GsonUtils.fromJsonToMap(IOUtils.toString(inputStream), String.class, Object.class);
        }
        return districtMap;
    }

    private static List<Map<String, String>> obtainDistricts() {
        if (districts == null) {
            provinces = new ArrayList<Map<String, String>>();
            districts = new ArrayList<Map<String, String>>();
            districtMap = obtainDistrictMap();
            Set<String> provinceCodes = districtMap.keySet();
            for (String provinceCode : provinceCodes) {
                Map<String, Object> provinceMap = MapUtils.getMap(districtMap, provinceCode);
                Map<String, String> province = new HashMap<String, String>();
                province.put("code", provinceCode);
                province.put("name", MapUtils.getString(provinceMap, "name"));
                provinces.add(province);
                districts.add(province);
                Map<String, Object> citiesMap = MapUtils.getMap(MapUtils.getMap(districtMap, provinceCode), "child");
                if (MapUtils.isEmpty(citiesMap)) {
                    continue;
                }
                Set<String> cityCodes = citiesMap.keySet();
                for (String cityCode : cityCodes) {
                    Map<String, Object> cityMap = MapUtils.getMap(citiesMap, cityCode);
                    Map<String, String> city = new HashMap<String, String>();
                    city.put("code", cityCode);
                    city.put("name", MapUtils.getString(cityMap, "name"));
                    districts.add(city);

                    Map<String, String> districtMap = MapUtils.getMap(cityMap, "child");
                    if (MapUtils.isEmpty(districtMap)) {
                        continue;
                    }

                    for (Map.Entry<String, String> entry : districtMap.entrySet()) {
                        Map<String, String> district = new HashMap<String, String>();
                        district.put("code", entry.getKey());
                        district.put("name", entry.getValue());
                        districts.add(district);
                    }
                }
            }
        }
        return districts;
    }

    public static String obtainName(String code) {
        return null;
    }

    public static List<Map<String, String>> obtainProvinces() {
        return null;
    }

    public static void main(String[] args) {
        obtainDistricts();
    }
}
