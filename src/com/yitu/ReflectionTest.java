package com.yitu;

import com.company.Name;
import com.company.Person;

import java.lang.reflect.Constructor;

public class ReflectionTest {

    public static void main(String[] args)throws Exception{
        Class clazz = Person.class;
        Constructor constructor = clazz.getDeclaredConstructor(Name.class);
        Person person =(Person) constructor.newInstance(new Name("kangyu", "liu"));
        Constructor constructor2 = clazz.getDeclaredConstructor();
        constructor2.setAccessible(true);
        Person person2 = (Person) constructor2.newInstance();
    }
}
