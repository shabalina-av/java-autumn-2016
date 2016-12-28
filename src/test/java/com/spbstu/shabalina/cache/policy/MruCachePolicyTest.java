package com.spbstu.shabalina.cache.policy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MruCachePolicyTest {
  @Test
  public void singleElement() {
    final MruCachePolicy<Integer> policy = new MruCachePolicy<>();
    policy.touchItem(1);

    assertEquals(1, policy.replace().intValue());
  }


  @Test
  public void policy() {
    final MruCachePolicy<Integer> policy = new MruCachePolicy<>();
    policy.touchItem(1);
    policy.touchItem(2);
    policy.touchItem(3);

    assertEquals(3, policy.replace().intValue());
    assertEquals(2, policy.replace().intValue());
    assertEquals(1, policy.replace().intValue());
  }
}
