package com.spbstu.shabalina.cache.policy;

public class MruCachePolicy<K> extends RecentlyUsedBasedPolicy<K> {
  @Override
  public K replace() {
    if (time2Item.isEmpty()) {
      return null;
    }

    final K removed = time2Item.lastEntry().getValue();
    removeItem(removed);
    return removed;
  }
}
