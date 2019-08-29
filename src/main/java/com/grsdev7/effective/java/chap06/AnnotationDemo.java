package com.grsdev7.effective.java.chap06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class AnnotationDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> testClass = Class.forName(MyTestClass.class.getName());

        List<Method> methods = stream(testClass.getMethods())
                //.peek(out::println)
                .filter(method -> method.isAnnotationPresent(TestCase.class)).collect(toList());


        for(Method method : methods){
            TestCase annotation = method.getAnnotation(TestCase.class);
            out.printf("testing method %s, given:%s, when:%s, then:%s %n", method.getName(),annotation.given(),annotation.when(), annotation.then() );
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestCase{
    String given();
    String when();
    String then();
}

class MyTestClass{

    @TestCase(given = "id is valid", when = "findById invoked", then = "return entity")
    public void shouldReturnValue(){

    }
}