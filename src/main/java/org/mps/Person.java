package org.mps;

import java.util.List;

/**
 * Class representing a person with a name, age and gender
 *
 * @author José Manuel Sánchez Rico
 */
public class Person {
    private final String name;
    private final int age;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static double[] averageAgePerGender(List<Person> list) {
        return null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
