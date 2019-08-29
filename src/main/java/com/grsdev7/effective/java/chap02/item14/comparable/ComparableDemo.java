package com.grsdev7.effective.java.chap02.item14.comparable;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

import static java.lang.System.out;

public class ComparableDemo {

    public static void main(String[] args) {

        Set<BigDecimal> hashSet = new HashSet<>();
        Set<BigDecimal> treeSet = new TreeSet<>();

        hashSet.add(new BigDecimal("1.00"));
        hashSet.add(new BigDecimal("1.0"));

        treeSet.add(new BigDecimal("1.00"));
        treeSet.add(new BigDecimal("1.0"));

        out.println(hashSet);
        out.println(treeSet);


        Comparator<Car> comparator = Comparator.comparing(car -> car.getId());
    }
}

@Data
class Car{

    private Long id;
}

class Test{

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("oragne", "mango");

       //fruits.add("apple");
        out.println(fruits.getClass());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
    }
}