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
        if (name == null)
        {
            throw new IllegalArgumentException("Null name");
        }
        if (age < 0)
        {
            throw new IllegalArgumentException("Negative age");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static double[] averageAgePerGender(List<Person> list) {
        double[] averageAgePerGender;

        checkList(list);
        averageAgePerGender = new double[2];
        calculateAverage(list, Gender.male, averageAgePerGender, 0);
        calculateAverage(list, Gender.female, averageAgePerGender, 1);
        return averageAgePerGender;
    }

    private static void checkList(List<Person> list) {
        if (list == null)
        {
            throw new IllegalArgumentException("Null list");
        }
        if (list.size() == 0)
        {
            throw new IllegalArgumentException("Empty list given");
        }
    }

    private static void calculateAverage(List<Person> list, Gender gender, double[] averageAgePerGender, int x) {
        int size = 0;
        int sumOfAges = 0;

        for (Person person : list) {
            if (person.getGender().equals(gender))
            {
                sumOfAges += person.getAge();
                size++;
                if (sumOfAges < 0)
                {
                    throw new RuntimeException("Overflow when adding the total of ages");
                }
            }
        }
        if (size > 0) {
            averageAgePerGender[x] = (double) sumOfAges / size;
        } else {
            averageAgePerGender[x] = 0.0;
        }
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
