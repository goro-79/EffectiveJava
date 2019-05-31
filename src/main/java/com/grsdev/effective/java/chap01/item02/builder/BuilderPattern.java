package com.grsdev.effective.java.chap01.item02.builder;


import java.util.Objects;

import static java.util.Objects.requireNonNull;

class User {

    private final Long id;

    private final String name;

    private Integer age;

    private Integer mobileNumber;

    User(Long id, String name){
        requireNonNull(id);
        requireNonNull(name);
        this.id = id;
        this.name = name;
    }

    static class Builder {

        private Long id;

    }
}

public class BuilderPattern {

    public static void main(String[] args) {

    }
}
