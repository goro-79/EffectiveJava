package com.grsdev7.effective.java.chap9;

import java.util.EnumSet;

import static java.lang.System.out;

public class PreferForEach {

    public static void main(String[] args) {
        out.println(EnumSet.allOf(Face.class));
        out.println(EnumSet.of(Face.ONE, Face.FIVE));
        out.println(EnumSet.complementOf(EnumSet.of(Face.ONE)));
        out.println(EnumSet.noneOf(Face.class).add(Face.SIX));

        // print dice combo
        EnumSet<Face> dice1 = EnumSet.allOf(Face.class);
        EnumSet<Face> dice2 = EnumSet.allOf(Face.class);

        for(Face face1 : dice1)
            for(Face face2: dice2)
                out.println(face1 + "-" +  face2);

        dice1.stream()
        .flatMap(dice1Value -> dice2.stream().map(dice2Value->  dice1Value + "-" +dice2Value))
        .forEach(out::println);
    }
}

enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX}