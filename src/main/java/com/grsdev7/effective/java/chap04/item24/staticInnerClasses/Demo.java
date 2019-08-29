package com.grsdev7.effective.java.chap04.item24.staticInnerClasses;

public class Demo {

    public static void main(String[] args) {
        Employee employee = new Employee();
        Employee.ROLE role = Employee.ROLE.DBA;
       Class type=int.class;
    }

}


class Employee{

    static enum ROLE{
        DEV, QA, DBA;
    }

}