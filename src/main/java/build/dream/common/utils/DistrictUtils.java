package build.dream.common.utils;

import build.dream.common.beans.District;
import build.dream.common.constants.Constants;
import build.dream.common.constants.RedisKeys;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

public class DistrictUtils {
    public static void initData() {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.DISTRICTS);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            zipInputStream.getNextEntry();

            CommonRedisUtils.del(RedisKeys.KEY_DISTRICTS, RedisKeys.KEY_PROVINCES, RedisKeys.KEY_PID_DISTRICTS);
            List<District> districts = JacksonUtils.readValueAsList(IOUtils.toString(zipInputStream, Constants.CHARSET_UTF_8), District.class);
            List<District> provinces = new ArrayList<District>();
            for (District district : districts) {
                CommonRedisUtils.hset(RedisKeys.KEY_DISTRICTS, district.getId(), JacksonUtils.writeValueAsString(district));
                if ("0".equals(district.getPid())) {
                    provinces.add(district);
                }
            }

            Map<String, List<District>> districtsMap = districts.stream().collect(Collectors.groupingBy(District::getPid));
            for (Map.Entry<String, List<District>> entry : districtsMap.entrySet()) {
                CommonRedisUtils.hset(RedisKeys.KEY_PID_DISTRICTS, entry.getKey(), JacksonUtils.writeValueAsString(entry.getValue()));
            }
            CommonRedisUtils.set(RedisKeys.KEY_PROVINCES, JacksonUtils.writeValueAsString(provinces));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static District obtainDistrictById(String id) {
        String districtJson = CommonRedisUtils.hget(RedisKeys.KEY_DISTRICTS, id);
        if (StringUtils.isBlank(districtJson)) {
            return null;
        }
        return JacksonUtils.readValue(districtJson, District.class);
    }

    public static List<District> obtainDistrictsByPid(String pid) {
        String districtsJson = CommonRedisUtils.hget(RedisKeys.KEY_PID_DISTRICTS, pid);
        if (StringUtils.isBlank(districtsJson)) {
            return null;
        }
        return JacksonUtils.readValueAsList(districtsJson, District.class);
    }

    public static List<District> obtainAllProvinces() {
        return JacksonUtils.readValueAsList(CommonRedisUtils.get(RedisKeys.KEY_PROVINCES), District.class);
    }
}
