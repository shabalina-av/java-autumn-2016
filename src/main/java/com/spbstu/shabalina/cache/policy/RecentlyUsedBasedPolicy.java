package com.spbstu.shabalina.cache.policy;

import com.spbstu.shabalina.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("WeakerAccess")
public abstract class RecentlyUsedBasedPolicy<K> implements Cache.ReplacementPolicy<K> {
  protected final TreeMap<Long, K> time2Item = new TreeMap<>();
  private final Map<K, Long> item2time = new HashMap<>();
  private long counter = Long.MIN_VALUE;

  public void touchItem(K item) {
    Long time = item2time.get(item);
    if (time != null) {
      time2Item.remove(time);
    }

    item2time.put(item, counter);
    time2Item.put(counter, item);

    counter++;
  }

  void removeItem(K item) {
    time2Item.remove(item2time.remove(item));
  }
}
