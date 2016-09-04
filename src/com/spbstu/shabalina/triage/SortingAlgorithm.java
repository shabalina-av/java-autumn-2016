package com.spbstu.shabalina.triage;

import com.sun.istack.internal.NotNull;

public interface SortingAlgorithm {
  int[] sort(@NotNull int[] array);
}
