package com.grsdev7.effective.java.chap9;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.util.List.of;

public class WhenForEachCannotBeUsed {

    public static void main(String[] args) {

        // destructive filtering
        List<String> colours = new ArrayList<>(of("red", "blue", "green", "yellow", "black", "grey"));
        colours.removeIf(colour -> colour.equalsIgnoreCase("yellow"));
        out.println(colours);
    }
}
