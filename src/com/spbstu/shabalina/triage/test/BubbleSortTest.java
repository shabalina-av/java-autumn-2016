package com.spbstu.shabalina.triage.test;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.spbstu.shabalina.triage.impl.quadratic.BubbleSort;
import com.sun.istack.internal.NotNull;

import static org.junit.Assert.*;

public class BubbleSortTest extends SortingTestCase{

    public BubbleSortTest() {
        super(new BubbleSort());
    }
}
