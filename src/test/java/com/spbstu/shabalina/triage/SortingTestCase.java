package com.spbstu.shabalina.triage;

import org.junit.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

abstract class SortingTestCase {
  private final SortingAlgorithm myAlgorithm;

  SortingTestCase(SortingAlgorithm algorithm) {
    myAlgorithm = algorithm;
  }

  @Test
  public void emptyArray() {
    check(myAlgorithm, new Integer[]{});
  }

  @Test
  public void oneElement() {
    check(myAlgorithm, new Integer[]{1});
  }

  @Test
  public void elementsSorted() {
    check(myAlgorithm, new Integer[]{1, 2, 3, 4, 5});
  }

  @Test
  public void elementsReversed() {
    check(myAlgorithm, new Integer[]{2, 1, -1, -3, -5});
  }

  @Test
  public void threeShuffle() {
    check(myAlgorithm, new Integer[]{2, 3, 1});
  }

  @Test
  public void negativeElements() {
    check(myAlgorithm, new Integer[]{-1, -3, -10, -14});
  }

  @Test
  public void tenElementsShuffle() {
    check(myAlgorithm, new Integer[]{-1, -3, -5, 10, 15, 20, -10, -20, -100, 100});
  }

  @Test
  public void sameElements() {
    check(myAlgorithm, new Integer[]{10, 10, 10, 10});
  }

  @Test
  public void largeRandom() {
    Random random = new Random();
    int length = Math.abs(random.nextInt()) % 2000 + 1000; // from 1000 to 3000 exclusive
    Integer[] array = new Integer[length];
    Stream.generate(random::nextInt).limit(length).collect(Collectors.toList()).toArray(array);
    check(myAlgorithm, array);
  }

  @Test
  public void testStrings() {
    check(myAlgorithm, new String[]{"b", "d", "a", "c"});
  }

  @SuppressWarnings("WeakerAccess")
  protected final <T extends Comparable<T>> void check(SortingAlgorithm algorithm, T[] array) {
    T[] result = array.clone();
    algorithm.sort(result);
    assertEquals(result.length, array.length);

    assertTrue("Found new elements", checkContainsAllElements(result, array));
    assertTrue("Items have disappeared.", checkContainsAllElements(array, result));

    assertTrue("Result is unordered", checkSorted(result));
  }

  private <T extends Comparable<T>> boolean checkContainsAllElements(T[] small, T[] big) {
    boolean[] found = new boolean[small.length];
    for (T elem : small) {
      boolean matched = false;
      for (int j = 0; j < big.length; j++) {
        if ((elem.compareTo(big[j]) == 0) && (!found[j])) {
          matched = true;
          found[j] = true;
          break;
        }
      }
      if (!matched) return false;
    }
    return true;
  }

  private <T extends Comparable<T>> boolean checkSorted(T[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1].compareTo(array[i]) > 0) {
        return false;
      }
    }

    return true;
  }
}
