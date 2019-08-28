package com.grsdev.effective.java.chap05;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

public class Generics {

    public static void main(String[] args) {

        List<Integer> list1 = asList(1,2,3);
        List<String> list2 = asList("apple","mango","pear");
        swap(list2, 0,2);
        out.println(list2);
    }

    private static <E> void swap(List<E> list, int i, int j) {
        list.set(i,list.set(j,list.get(i)));
    }
}

class GenericWithVargs{

    public static void main(String[] args) {
        counter(asList("apple"),asList("mango"));
    }

    static void counter(List<String> ... args){
        List<String>[] arr = args;

        Object[] arr1 = arr;
        arr1[0] = asList(1,23);

        String s = args[0].get(0);
        out.println(arr1);
    }
}