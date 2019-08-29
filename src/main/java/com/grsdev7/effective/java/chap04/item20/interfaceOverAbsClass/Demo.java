package com.grsdev7.effective.java.chap04.item20.interfaceOverAbsClass;

import static java.lang.System.out;

public class Demo {

    public static void main(String[] args) {

        Player player = new Player();
        player.move();
        player.dance();
    }
}

interface Movable{

    default void move(){
        out.println("Movable - i am moved");
    }
}

interface Danceable{

    void dance();
}

class Player implements Movable{

    private DanceFunctionality danceFunctionality = new DanceFunctionality();

    void dance(){
        danceFunctionality.dance();
    }

    private class DanceFunctionality implements Danceable{

        @Override
        public void dance() {
            out.println(getClass().getSimpleName() + " - i am dancing");


            class Local{

                private  int value=0;
            }

            Local local = new Local();
            local.value=1;
        }
    }
}

