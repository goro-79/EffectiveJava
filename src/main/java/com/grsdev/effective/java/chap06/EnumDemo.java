package com.grsdev.effective.java.chap06;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.event.FocusAdapter;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toMap;

public class EnumDemo {

    public static void main(String[] args) {

        for (Designation designation : Designation.values())
            out.println(designation.getGrade() + " : " + designation.getBonus());
    }
}

@AllArgsConstructor
enum Designation {
    ASSOCIATE("A1", new RandomValueBonusCalculator()::getBonus), SR_ASSOCIATE("A2", new RandomValueBonusCalculator()::getBonus),
    MANAGER("B1", new FixedValueBonusCalculator()::getBonus);

    @Getter
    private final String grade;

    private final Supplier<Integer> bonusCalculator;

    int getBonus() {
        return bonusCalculator.get();
    }
}

class FixedValueBonusCalculator implements BonusCalculator {

    @Override
    public int getBonus() {
        return 100;
    }
}

class RandomValueBonusCalculator implements BonusCalculator {

    @Override
    public int getBonus() {
        return 100 * ThreadLocalRandom.current().nextInt(3);
    }
}


interface BonusCalculator {

    int defaultBonus = 10;

    default int getBonus() {
        return defaultBonus;
    }
}

enum Operation {

    PLUS;
    private final static Map<String, Operation> stringToOperation =
            Stream.of(values()).collect(toMap(Object::toString, Function.identity()));

    static Optional<Operation> fromString(String string) {
        return ofNullable(stringToOperation.get(string.toUpperCase()));
    }
}

interface DiscountStratgey{

    default int calculate(){
        return 100;
    }
}

enum DiscountType implements   DiscountStratgey{

    HALF_MARGIN, ZERO_MARGIN{

        @Override
        public int calculate(){
            return 0;
        }
    };
}

class DiscountDemo{

    public static void main(String[] args) {

        DiscountType discountType = DiscountType.ZERO_MARGIN;
        out.println(discountType.calculate());
    }
}