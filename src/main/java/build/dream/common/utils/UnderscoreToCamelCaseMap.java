package build.dream.common.utils;

import java.util.HashMap;

public class UnderscoreToCamelCaseMap<V> extends HashMap<String, V> {
    @Override
    public V put(String key, V value) {
        return super.put(NamingStrategyUtils.underscoreToCamelCase(key), value);
    }
}
