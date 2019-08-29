package com.grsdev7.fpij.chap01;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Chap01Demo {

    public static void main(String[] args) {
        discountCalculation();
    }

    private static void discountCalculation() {

        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));

        prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .reduce(BigDecimal::add)
                .map(sum -> sum.multiply(new BigDecimal(".9")))
                .ifPresent(out::println);
    }
}
