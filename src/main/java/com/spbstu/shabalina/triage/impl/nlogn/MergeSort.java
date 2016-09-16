package com.spbstu.shabalina.triage.impl.nlogn;

import com.sun.istack.internal.NotNull;

public class MergeSort {
  public static <T extends Comparable<T>> void sort(@NotNull T[] inputArray) {
    if (inputArray.length <= 1) {
      return;
    }

    int length = inputArray.length / 2;
    //noinspection unchecked
    T[] left = (T[]) new Comparable<?>[length];
    //noinspection unchecked
    T[] right = (T[]) new Comparable<?>[inputArray.length - length];

    System.arraycopy(inputArray, 0, left, 0, length);
    System.arraycopy(inputArray, length, right, 0, inputArray.length - length);

    sort(left);
    sort(right);
    merge(left, right, inputArray);
  }

  private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] inputArray) {
    int indexLeft = 0;
    int indexRight = 0;
    int indexResult = 0;

    while (indexLeft < left.length && indexRight < right.length) {
      if (left[indexLeft].compareTo(right[indexRight])<0) {
        inputArray[indexResult] = left[indexLeft];
        indexLeft++;
      } else {
        inputArray[indexResult] = right[indexRight];
        indexRight++;
      }
      indexResult++;
    }

    for (int i = indexLeft; i < left.length; i++) {
      inputArray[indexResult] = left[i];
      indexResult++;
    }
    for (int i = indexRight; i < right.length; i++) {
      inputArray[indexResult] = right[i];
      indexResult++;
    }
  }

}
