package com.spbstu.shabalina.cache;

public interface Cache<K, V> {
  boolean put(K key, V value);

  V get(K key);

  int size();

  int capacity();

  interface ReplacementPolicy<K> {
    // nothing to replace -> null
    K replace();

    void touchItem(K item);
  }
}
