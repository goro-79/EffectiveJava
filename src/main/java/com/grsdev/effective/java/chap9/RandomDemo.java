package com.grsdev.effective.java.chap9;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class RandomDemo {

    public static void main(String[] args) {
        IntStream.range(1,Integer.MAX_VALUE/1000)
                .mapToLong(RandomDemo::random);
                //.collect(Collectors.groupingBy(t->t,Collectors.counting()));
    }

    static Random rnd = new Random();
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }
}
