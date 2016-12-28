package com.spbstu.shabalina.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LruCacheTest extends CacheTestCase {
  @Override
  public <K, V> Cache<K, V> createCache(int size) {
    return new LruCache<>(size);
  }

  @Test
  public void policy() {
    final Cache<Integer, Double> cache = createCache(3);

    cache.put(1, 1.);
    cache.put(2, 2.);
    cache.put(3, 3.);

    assertEquals(1., cache.get(1), 0.1);
    assertEquals(2., cache.get(2), 0.1);
    assertEquals(3., cache.get(3), 0.1);

    cache.put(4, 4.);

    assertEquals(3, cache.size());
    assertEquals(3, cache.capacity());
    assertNull(cache.get(1));
    assertNotNull(cache.get(4));
    assertNotNull(cache.get(3));
    assertNotNull(cache.get(2));
  }
}