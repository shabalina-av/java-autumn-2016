package com.spbstu.shabalina.triage;

interface SortingAlgorithm {
  <T extends Comparable<T>> void sort(T[] array);
}
