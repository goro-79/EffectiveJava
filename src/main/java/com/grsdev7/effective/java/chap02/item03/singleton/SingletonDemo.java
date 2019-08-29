package com.grsdev7.effective.java.chap02.item03.singleton;


import java.time.LocalDate;

import static com.grsdev7.effective.java.chap02.item03.singleton.Singleton2.INSTANCE;
import static java.lang.System.out;


public class SingletonDemo {

    public static void main(String[] args) {

        // option1
        out.println("Singleton1 instance 1 : " + Singleton1.getInstance());
        out.println("Singleton1 instance 2 : " + Singleton1.getInstance());

        // option2
        out.println("Singleton2 instance 1==2 : " + (INSTANCE == INSTANCE));

        out.println(INSTANCE.getTime());
        INSTANCE.run();
    }
}


// option 1

class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    static Singleton1 getInstance() {
        return INSTANCE;
    }
}

enum Singleton2 implements Runnable{

    INSTANCE;

    LocalDate getTime() {
        return LocalDate.now();
    }

    public void run(){
        out.println(getClass().getSimpleName() + " : i ran");
    }
}

