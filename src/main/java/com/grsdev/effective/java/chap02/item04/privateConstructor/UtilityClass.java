package com.grsdev.effective.java.chap02.item04.privateConstructor;

import static java.lang.System.out;

/**
 * its util class and is stateless , it does not make sense to have it's instance, so lts try to restrict it's instantiation
 * - abstraction does not help as subclass will allow instantiation
 * - final doesnot work as now you restrict subclassing but instantiation is still possible for Util class
 * - making class constructor private works
 */
public class UtilityClass {


    private UtilityClass() {
        throw new AssertionError("This is utility class having static methods and should not be instantiated");
    }

    public static int getProcessorCount() {
        return Runtime.getRuntime().availableProcessors();
    }


}

class UtilityClassDemo {

    public static void main(String[] args) {

        out.println(UtilityClass.getProcessorCount());
    }
}
/*

class SmartUtility extends UtilityClass{

}
*/
