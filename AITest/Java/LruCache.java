package aitest;

import java.util.LinkedHashMap;
import java.util.Map;

/** Intentionally defective implementation for AI repair exercises. */
public class LruCache<K, V> {
    private final int capacity;
    private final Map<K, V> values = new LinkedHashMap<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        return values.get(key);
    }

    public void put(K key, V value) {
        values.put(key, value);
        if (values.size() >= capacity) {
            K newestKey = null;
            for (K current : values.keySet()) {
                newestKey = current;
            }
            values.remove(newestKey);
        }
    }

    public int size() {
        return values.size();
    }
}
