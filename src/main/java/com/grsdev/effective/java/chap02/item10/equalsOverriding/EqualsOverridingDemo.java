package com.grsdev.effective.java.chap02.item10.equalsOverriding;

import java.util.Arrays;
import java.util.List;

public class EqualsOverridingDemo {

    public static void main(String[] args) {


        BadReflexitivity object1 = new BadReflexitivity();

        List<BadReflexitivity> list = Arrays.asList(object1);

        System.out.println(list.contains(object1));
    }
}

class BadReflexitivity{

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}