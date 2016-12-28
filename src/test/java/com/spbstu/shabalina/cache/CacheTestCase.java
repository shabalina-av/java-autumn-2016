package com.spbstu.shabalina.cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public abstract class CacheTestCase {
  @Test
  public void zeroSize() {
    final Cache<Integer, Double> cache = createCache(0);
    cache.put(10, 1.);

    assertNull(cache.get(10));
  }

  @Test
  public void oneSize() {
    final Cache<Integer, Double> cache = createCache(1);
    cache.put(10, 1.);

    assertEquals(1., cache.get(10), 0.01);
    cache.put(11, 2.);
    assertNull(cache.get(10));
    assertEquals(2., cache.get(11), 0.01);
  }

  @Test
  public void replaceByKey() {
    final Cache<Integer, Double> cache = createCache(1);
    cache.put(10, 1.);
    cache.put(10, 2.);

    assertEquals(2., cache.get(10), 0.01);
  }

  @Test
  public void absentItem() {
    final Cache<Integer, Double> cache = createCache(10);
    cache.put(10, 10.);

    assertNull(cache.get(11));
  }

  public abstract <K, V> Cache<K, V> createCache(int size);
}
