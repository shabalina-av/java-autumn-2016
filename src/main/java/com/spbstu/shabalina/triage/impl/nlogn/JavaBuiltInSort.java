package com.spbstu.shabalina.triage.impl.nlogn;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class JavaBuiltInSort implements SortingAlgorithm {
  @Override
  public void sort(@NotNull int[] array) {
    Arrays.sort(array);
  }
}
