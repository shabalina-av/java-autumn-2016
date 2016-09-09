package com.spbstu.shabalina.triage.impl.nlogn;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class MergeSort implements SortingAlgorithm {
  @Override
  public void sort(@NotNull int[] inputArray) {
    if (inputArray.length <= 1) {
      return;
    }

    int length = inputArray.length / 2;
    int[] left = new int[length];
    int[] right = new int[inputArray.length - length];

    System.arraycopy(inputArray, 0, left, 0, length);
    System.arraycopy(inputArray, length, right, 0, inputArray.length - length);

    sort(left);
    sort(right);
    merge(left, right, inputArray);
  }

  private void merge(int[] left, int[] right, int[] inputArray) {
    int indexLeft = 0;
    int indexRight = 0;
    int indexResult = 0;

    while (indexLeft < left.length && indexRight < right.length) {
      if (left[indexLeft] < right[indexRight]) {
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
