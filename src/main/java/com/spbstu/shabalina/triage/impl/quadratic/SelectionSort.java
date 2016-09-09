package com.spbstu.shabalina.triage.impl.quadratic;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class SelectionSort implements SortingAlgorithm {
  @Override
  public void sort(@NotNull int[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      int index_min = i;
      for (int k = i + 1; k < inputArray.length; k++) {
        if (inputArray[k] < inputArray[index_min]) {
          index_min = k;
        }
      }
      int help = inputArray[i];
      inputArray[i] = inputArray[index_min];
      inputArray[index_min] = help;
    }
  }
}
