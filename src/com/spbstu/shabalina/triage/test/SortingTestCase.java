package com.spbstu.shabalina.triage.test;

import com.spbstu.shabalina.triage.SortingAlgorithm;
import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

abstract class SortingTestCase {
  private final SortingAlgorithm myAlgorithm;

  SortingTestCase(@NotNull SortingAlgorithm algorithm) {
    myAlgorithm = algorithm;
  }

  @Test
  public void oneElement() {
    check(myAlgorithm, new int[]{1});
  }

  @Test
  public void twoElementsSorted() {
    check(myAlgorithm, new int[]{1, 2});
  }

  @Test
  public void twoElementsReversed() {
    check(myAlgorithm, new int[]{2, 1});
  }

  @Test
  public void threeShuffle() {
    check(myAlgorithm, new int[]{2, 3, 1});
  }

  @Test
  public void negativeElements() {
    check(myAlgorithm, new int[]{-1, -3, -10, -14});
  }

  @Test
  public void tenElementsShuffle() {
    check(myAlgorithm, new int[]{-1, -3, -5, 10, 15, 20, -10, -20, -100, 100});
  }

  @Test
  public void sameElements() {
    check(myAlgorithm, new int[]{10, 10, 10, 10});
  }

  @Test
  public void largeRandom() {
    Random random = new Random();
    int length = Math.abs(random.nextInt()) % 2000 + 1000; // from 1000 to 3000 exclusive
    int[] array = IntStream.generate(random::nextInt).limit(length).toArray();
    check(myAlgorithm, array);
  }

  @SuppressWarnings("WeakerAccess")
  protected final void check(@NotNull SortingAlgorithm algorithm, @NotNull int[] array) {
    int[] result = algorithm.sort(array);
    assertEquals(result.length, array.length);
    for (int val : result) {
      assertTrue(IntStream.of(array).anyMatch(value -> val == value));
    }

    for (int val : array) {
      assertTrue(IntStream.of(result).anyMatch(value -> val == value));
    }

    checkSorted(algorithm.sort(array));
  }

  private void checkSorted(@NotNull int[] array) {
    for (int i = 1; i < array.length; i++) {
      assertTrue(array[i - 1] <= array[i]);
    }
  }
}
