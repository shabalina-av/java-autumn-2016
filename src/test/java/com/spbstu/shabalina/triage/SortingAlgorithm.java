package com.spbstu.shabalina.triage;


import com.sun.istack.internal.NotNull;

interface SortingAlgorithm<T extends Comparable<T>> {
  void sort(@NotNull T[] array);
}
