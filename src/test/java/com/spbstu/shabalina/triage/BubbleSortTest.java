package com.spbstu.shabalina.triage;

import com.spbstu.shabalina.triage.impl.quadratic.BubbleSort;

public class BubbleSortTest extends SortingTestCase {

  public BubbleSortTest() {
    super(BubbleSort::sort);
  }
}
