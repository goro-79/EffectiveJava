package com.grsdev7.effective.java.chap04.item18.composition;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static java.lang.System.out;

public class CompositionDemo {

    public static void main(String[] args) {

        InstrumentedHashSet set = InstrumentedHashSet.newInstance(HashSet::new);

        set.add("pineapple");
        out.println(set.getCounter());
        set.addAll(Arrays.asList("mango", "apple", "orange"));
        out.println(set.getCounter());
    }
}

final class InstrumentedHashSet {

    private Set set;

    private int counter;

    private <E> InstrumentedHashSet(Supplier<Set<E>> bucket) {
        this.set = bucket.get();
    }

    public static <E> InstrumentedHashSet newInstance(@NonNull Supplier<Set<E>> bucket) {
        return new InstrumentedHashSet(bucket);
    }

    public int getCounter() {
        return counter;
    }

    public boolean add(Object o) {
        counter++;
        return set.add(o);
    }

    public boolean addAll(@NonNull Collection c) {
        counter += c.size();
        return set.add(c);
    }
}

