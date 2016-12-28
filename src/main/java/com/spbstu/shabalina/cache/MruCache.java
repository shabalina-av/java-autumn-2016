package com.spbstu.shabalina.cache;


import com.spbstu.shabalina.cache.policy.MruCachePolicy;

@SuppressWarnings("WeakerAccess")
public class MruCache<K, V> extends AbstractCache<K, V> {
  public MruCache(int size) {
    super(size, new MruCachePolicy<>());
  }
}
