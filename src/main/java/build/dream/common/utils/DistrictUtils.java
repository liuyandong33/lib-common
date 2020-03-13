package build.dream.common.utils;

import build.dream.common.beans.District;
import build.dream.common.constants.Constants;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

public class DistrictUtils {
    private static final Map<String, District> DISTRICT_MAP;
    private static final Map<String, List<District>> DISTRICTS_MAP;
    private static final List<District> PROVINCES;

    static {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.DISTRICTS);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            zipInputStream.getNextEntry();
            List<District> districts = JacksonUtils.readValueAsList(IOUtils.toString(zipInputStream, Constants.CHARSET_UTF_8), District.class);
            DISTRICTS_MAP = districts.stream().collect(Collectors.groupingBy(District::getPid));
            DISTRICT_MAP = new HashMap<String, District>();
            PROVINCES = new ArrayList<District>();
            for (District district : districts) {
                DISTRICT_MAP.put(district.getId(), district);
                if ("0".equals(district.getPid())) {
                    PROVINCES.add(district);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static District obtainDistrictById(String id) {
        return DISTRICT_MAP.get(id);
    }

    public static List<District> obtainDistrictsByPid(String pid) {
        return DISTRICTS_MAP.get(pid);
    }

    public static List<District> obtainAllProvinces() {
        return PROVINCES;
    }
}
