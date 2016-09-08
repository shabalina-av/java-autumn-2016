package com.spbstu.shabalina.triage.impl.nlogn;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class JavaBuiltInSort implements SortingAlgorithm {
  @Override
  public int[] sort(@NotNull int[] array) {
    int[] copy = array.clone();
    Arrays.sort(copy);
    return copy;
  }
}
