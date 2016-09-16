package com.spbstu.shabalina.triage.impl.nlogn;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class JavaBuiltInSort {
  public static <T extends Comparable<T>>void sort(@NotNull T[] array) {
    Arrays.sort(array);
  }
}
