package com.grsdev7.effective.java.chap02.item02.builder;




import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

class User {

    private final Long id;

    private final String name;

    private Integer age = 0;

    private Long mobileNumber = 0L;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.mobileNumber = builder.mobileNumber;
    }

    static class Builder {

        private final Long id;

        private final String name;

        private Integer age;

        private Long mobileNumber;

        Builder(Long id, String name) {
            requireNonNull(id);
            requireNonNull(name);
            this.id = id;
            this.name = name;
        }

        Builder age(Integer age) {
            this.age = age;
            return this;
        }

        Builder mobileNumber(Long mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        User build() {

            return new User(this);
        }
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, name=%s, age=%d, mobileNumber=%d]",id, name, age, mobileNumber);
    }
}

public class BuilderPattern {

    public static void main(String[] args) {

        User user = new User.Builder(1L, "Gaurav").build();
        out.println(user);

        User user1 = new User.Builder(1L,"Janki").age(29).mobileNumber(15206840703L).build();
        out.println(user1);
    }
}
