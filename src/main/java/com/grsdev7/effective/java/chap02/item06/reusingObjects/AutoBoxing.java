package com.grsdev7.effective.java.chap02.item06.reusingObjects;

import static java.lang.System.out;

public class AutoBoxing {

    public static void main(String[] args) {

        Timer.start();
        out.println(addIntegersUsingLong());
        out.println(Timer.getTimeTakenInSec());
    }

    private static Long addIntegersUsingLong() {

        Long sum = 0L;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static Long addIntegersUsinglong() {

        long sum = 0;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

}

class Timer {

    private static long startTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static long getTimeTakenInSec() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }
}