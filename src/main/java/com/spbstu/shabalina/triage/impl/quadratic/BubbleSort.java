package com.spbstu.shabalina.triage.impl.quadratic;

import com.sun.istack.internal.NotNull;

public class BubbleSort {
  public static<T extends Comparable<T>> void sort(@NotNull T[] inputArray) {
    int k = 0;
    while (k < inputArray.length) {
      boolean flag = false;
      for (int i = 0; i < inputArray.length - 1; i++) {
        if (inputArray[i].compareTo(inputArray[i + 1])>0 ) {
          flag = true;
          T bubble = inputArray[i];
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
