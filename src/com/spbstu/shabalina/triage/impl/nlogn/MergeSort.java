package com.spbstu.shabalina.triage.impl.nlogn;

import java.util.*;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class MergeSort implements SortingAlgorithm {
  @Override
  public int[] sort(@NotNull int[] inputArray) {
    if (inputArray.length <= 1) {
      return inputArray.clone();
    }

    int length = inputArray.length / 2;
    int[] left = new int[length];
    int[] right = new int[inputArray.length - length];

    System.arraycopy(inputArray, 0, left, 0, length);
    System.arraycopy(inputArray, length, right, 0, inputArray.length - length);

    int[] sortedLeft = sort(left);
    int[] sortedRight = sort(right);
    return merge(sortedLeft, sortedRight);
  }

  private int[] merge(int[] left, int[] right) {
    int indexLeft = 0;
    int indexRight = 0;
    int indexResult = 0;
    int[] result = new int[left.length + right.length];

    while (indexLeft < left.length && indexRight < right.length) {
      if (left[indexLeft] < right[indexRight]) {
        result[indexResult] = left[indexLeft];
        indexLeft++;
      } else {
        result[indexResult] = right[indexRight];
        indexRight++;
      }
      indexResult++;
    }

    for (int i = indexLeft; i < left.length; i++) {
      result[indexResult] = left[i];
      indexResult++;
    }
    for (int i = indexRight; i < right.length; i++) {
      result[indexResult] = right[i];
      indexResult++;
    }
    return result;
  }

}
