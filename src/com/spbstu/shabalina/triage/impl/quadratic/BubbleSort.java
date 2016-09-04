package com.spbstu.shabalina.triage.impl.quadratic;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public int[] sort(@NotNull int[] inputArray) {
        int[] outArray = inputArray.clone();
        int k = 0;
        while (k < outArray.length) {
            boolean flag = false;
            for (int i = 0; i < outArray.length - 1; i++) {
                if (outArray[i] > outArray[i + 1]) {
                    flag = true;
                    int bubble = outArray[i];
                    outArray[i] = outArray[i + 1];
                    outArray[i + 1] = bubble;
                }
            }
            if (!flag) {
                break;
            }
        }
        return outArray;
    }
}
