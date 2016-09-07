package com.spbstu.shabalina.triage.impl.quadratic;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public int[] sort(@NotNull int[] inputArray) {
        int[] outArray = inputArray.clone();
        for (int i = 0; i < outArray.length - 1; i++) {
            int index_min = i;
            for (int k = i + 1; k < outArray.length; k++) {
                if (outArray[k] < outArray[index_min]) {
                    index_min = k;
                }
            }
            int help = outArray[i];
            outArray[i] = outArray[index_min];
            outArray[index_min] = help;
        }
        return outArray;
    }
}
