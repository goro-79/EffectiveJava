package com.grsdev7.effective.java.chap02.item07.objectCleaning;

import java.io.FileNotFoundException;

import static java.lang.System.out;

public class ObjectCleaning {

    public static void main(String[] args) throws Exception {

        try (Room room = new Room()) {
            out.println("in try-block");
        } catch (Exception ex) {
            out.println("in catch-block  caught : " + ex.hashCode());
        } finally {
            out.println("in finally-block");
        }
    }
}

class Room implements AutoCloseable {

    @Override
    public void close() throws Exception {
        if (true) {
            Exception ex = new FileNotFoundException("thrown from close method");
            out.println("throwing exception from close method : " + ex.hashCode());
            throw ex;
        }
        out.println("I am cleaned !!!");
    }
}
