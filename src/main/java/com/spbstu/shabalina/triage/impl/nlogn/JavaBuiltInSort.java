package com.spbstu.shabalina.triage.impl.nlogn;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class JavaBuiltInSort {
  public static <T extends Comparable<T>>void sort(@NotNull T[] array) {
    Arrays.sort(array);
  }
}
