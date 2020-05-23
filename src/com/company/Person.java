package com.company;

public class Person {
    private final Name name;
    public Person(Name name){
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    public Name getName(){
        return new Name(this.name.getFirstName(), this.name.getLastName());
    }

    public static void main(String [] args){
        var name = new Name("Kangyu", "Liu");
        var person = new Person(name);
        System.out.println(person.getName().getFirstName());
        name.setFirstName("xxx");
        System.out.println(person.getName().getFirstName());
    }
}
