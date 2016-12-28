package com.spbstu.shabalina.cache;

import java.util.HashMap;
import java.util.Map;

class AbstractCache<K, V> implements Cache<K, V> {
  private final Map<K, V> items = new HashMap<>();
  private final ReplacementPolicy<K> cachePolicy;
  private final int cacheSize;

  AbstractCache(int size, ReplacementPolicy<K> policy) {
    cacheSize = size;
    cachePolicy = policy;
  }

  public void put(K key, V value) {
    if (items.containsKey(key) || items.size() < cacheSize) {
      addItem(key, value);
    } else {
      final K toReplace = cachePolicy.replace();
      if (toReplace != null) {
        items.remove(toReplace);
        addItem(key, value);
      }
    }
  }

  private void addItem(K key, V value) {
    cachePolicy.touchItem(key);
    items.put(key, value);
  }

  public V get(K key) {
    return items.get(key);
  }
}
