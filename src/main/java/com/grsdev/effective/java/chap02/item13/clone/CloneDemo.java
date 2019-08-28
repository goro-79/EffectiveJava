package com.grsdev.effective.java.chap02.item13.clone;

import lombok.Data;

import static java.lang.System.out;



class Employee implements Cloneable{

    private int id;

    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class Developer extends  Employee{

    private String technicalSkills;


    public Developer(int id, String name, String technicalSkills) {
        super(id, name);
        this.technicalSkills = technicalSkills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "technicalSkills='" + technicalSkills + '\'' +
                '}' + super.toString();
    }
}


public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employee emp1 = new Employee(1,"gaurav");
        Employee emp2 = emp1.clone();

        out.println(emp1);
        out.println(emp2);

        Developer dev1 = new Developer(1, "james", "java");
        Employee clone = dev1.clone();
        out.println("dev1 : "+ dev1);
        out.println("dev1.clone " + clone);
    }

}

class Item implements Cloneable{

}

class Food extends Item {

    final long id;

    Food() {
        this.id = 10001;
    }
}

@Data
class Fruit extends Food{

    String name;

    Fruit(String name){
        this.name = name;
    }

    Fruit copy(){
        try {
            return (Fruit) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString(){
        return "id : "+ id + " name : "+name;
    }
}
class CloneDemo1{

    public static void main(String[] args) {

        Fruit fruit = new Fruit("apple");
        out.println(fruit.copy());

    }
}

