package com.spbstu.shabalina.triage.impl.quadratic;

import org.jetbrains.annotations.NotNull;

public class SelectionSort {
  public static <T extends Comparable<T>>void sort(@NotNull T[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      int indexMin = i;
      for (int k = i + 1; k < inputArray.length; k++) {
        if (inputArray[k].compareTo(inputArray[indexMin]) < 0 ) {
          indexMin = k;
        }
      }
      T help = inputArray[i];
      inputArray[i] = inputArray[indexMin];
      inputArray[indexMin] = help;
    }
  }
}
