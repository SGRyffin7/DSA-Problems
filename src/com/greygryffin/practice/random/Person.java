package com.greygryffin.practice.random;

public class Person implements Comparable<Person>{
    String firstName;
    String lastName;
    int age;

    @Override
    public int compareTo(Person p) {
        return this.firstName.compareTo(p.firstName);
    }
}
