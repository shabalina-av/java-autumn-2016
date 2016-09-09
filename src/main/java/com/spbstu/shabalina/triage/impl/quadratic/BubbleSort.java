package com.spbstu.shabalina.triage.impl.quadratic;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class BubbleSort implements SortingAlgorithm {
  @Override
  public void sort(@NotNull int[] inputArray) {
    int k = 0;
    while (k < inputArray.length) {
      boolean flag = false;
      for (int i = 0; i < inputArray.length - 1; i++) {
        if (inputArray[i] > inputArray[i + 1]) {
          flag = true;
          int bubble = inputArray[i];
          inputArray[i] = inputArray[i + 1];
          inputArray[i + 1] = bubble;
        }
      }
      if (!flag) {
        break;
      }
    }
  }
}
