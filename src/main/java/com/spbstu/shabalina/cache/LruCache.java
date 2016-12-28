package com.spbstu.shabalina.cache;


import com.spbstu.shabalina.cache.policy.LruCachePolicy;

@SuppressWarnings("WeakerAccess")
public class LruCache<K, V> extends AbstractCache<K, V> {
  public LruCache(int size) {
    super(size, new LruCachePolicy<>());
  }
}
