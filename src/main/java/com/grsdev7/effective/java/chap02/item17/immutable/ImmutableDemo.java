package com.grsdev7.effective.java.chap02.item17.immutable;

import static java.lang.System.out;

public class ImmutableDemo {


    public static void main(String[] args) {

        int[] performaceScore = new int[]{1, 12, 3};

        Employee employee = new Employee(123L, "gaurav", performaceScore);

        out.println("employee : " + employee);
        out.println(performaceScore.equals(employee.getPerformanceScore()));
    }
}

final class Employee {

    private final Long id;

    private final String name;

    private final int[] performanceScore;

    Employee(Long id, String name, int[] performanceScore) {
        this.id = id;
        this.name = name;
        this.performanceScore = performanceScore.clone();
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int[] getPerformanceScore() {
        return this.performanceScore.clone();
    }

    @Override
    public String toString() {
        return String.format("Employee(id : %d, name : %s, performanceScore : %s)", getId(), getName(), getPerformanceScore());
    }

}
