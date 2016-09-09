package com.spbstu.shabalina.triage;

import com.spbstu.shabalina.triage.impl.nlogn.MergeSort;

public class MergeSortTest extends SortingTestCase {
  public MergeSortTest() {
    super(new MergeSort());
  }
}
