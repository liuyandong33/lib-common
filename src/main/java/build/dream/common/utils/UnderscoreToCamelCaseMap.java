package build.dream.common.utils;

import java.util.HashMap;

public class UnderscoreToCamelCaseMap<K, V> extends HashMap<K, V> {
    @Override
    public V put(K key, V value) {
        if (key instanceof String) {
            key = (K) NamingStrategyUtils.underscoreToCamelCase((String) key);
        }
        return super.put(key, value);
    }
}
