package build.dream.common.utils;

import build.dream.common.beans.District;
import build.dream.common.constants.Constants;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistrictUtils {
    private static final Map<Long, District> DISTRICT_MAP;
    private static final List<District> DISTRICTS;
    private static final Map<Long, List<District>> DISTRICTS_MAP;

    static {
        String districtsJson = null;
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.DISTRICTS_JSON)) {
            districtsJson = IOUtils.toString(inputStream, Constants.CHARSET_UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DISTRICTS = JacksonUtils.readValueAsList(districtsJson, District.class);
        DISTRICTS_MAP = DISTRICTS.stream().collect(Collectors.groupingBy(District::getPid));
        DISTRICT_MAP = new HashMap<Long, District>();
        for (District district : DISTRICTS) {
            DISTRICT_MAP.put(district.getId(), district);
        }
    }

    public static District obtainDistrictById(Long id) {
        return DISTRICT_MAP.get(id);
    }

    public static List<District> obtainDistrictsByPid(Long pid) {
        return DISTRICTS_MAP.get(pid);
    }
}
