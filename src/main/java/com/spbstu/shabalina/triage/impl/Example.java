package com.spbstu.shabalina.triage.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

/**
 * Created by wwwsh on 17.09.2016.
 */
class Student implements Comparable<Student> {
  private final int id;
  private final String name;

  Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int compareTo(Student student) {
    return Integer.compare(id, student.id);
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return String.format("id = %d, name = %s", id, name);
  }
}

class NameComporator implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return o1.getName().compareTo(o2.getName());
  }
}

public class Example {
  public static void main(String[] args) {
    Student a = new Student(2, "Nastya");
    Student b = new Student(1, "Vitaly");

    Student[] arr = new Student[] {a, b};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    Arrays.sort(arr, (o1, o2) -> o2.getName().compareTo(o1.getName()));
    System.out.println(Arrays.toString(arr));
  }
}
