package com.spbstu.shabalina.cache;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("WeakerAccess")
public abstract class AbstractCache<K, V> implements Cache<K, V> {
  private final Map<K, V> items = new HashMap<>();
  private final ReplacementPolicy<K> cachePolicy;
  private final int cacheCapacity;

  @Override
  public int size() {
    return items.size();
  }

  @Override
  public int capacity() {
    return cacheCapacity;
  }

  protected AbstractCache(int size, ReplacementPolicy<K> policy) {
    cacheCapacity = size;
    cachePolicy = policy;
  }

  public boolean put(K key, V value) {
    if (items.containsKey(key) || items.size() < cacheCapacity) {
      addItem(key, value);
    } else {
      final K toReplace = cachePolicy.replace();
      if (toReplace == null) {
        return false;
      }

      items.remove(toReplace);
      addItem(key, value);
    }

    return true;
  }

  private void addItem(K key, V value) {
    cachePolicy.touchItem(key);
    items.put(key, value);
  }

  public V get(K key) {
    if (items.containsKey(key)) {
      cachePolicy.touchItem(key);
    }
    return items.get(key);
  }
}
