package org.mps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonTest {

    List<Person> personList;
    @AfterAll
    public void setup()
    {
        Person person1, person2, person3;
        person1 = new Person("Pepe", 12, Gender.male);
        person2 = new Person("Juana", 23, Gender.female);
        person3 = new Person("Antonia", 13, Gender.female);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }

    @Test
    public void averagePerAgeThrowsExceptionIfNullListIsGiven()
    {
        List<Person> list = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(list));
    }

    @Test
    public void averagePerAgeThrowsExceptionIfEmptyListIsGiven()
    {
        List<Person> list = new ArrayList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(list));
    }

    @Test
    public void averagePerAgeOf1MaleIsThatAgeAnd0AtFemales()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Pepe", 3, Gender.male));
        averageList = Person.averageAgePerGender(personList);
        Assertions.assertEquals(3, averageList[0]);
        Assertions.assertEquals(0, averageList[1]);
    }


    @Test
    public void averagePerAgeOf1FemaleIsThatAgeAnd0AtMales()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Pepa", 3, Gender.female));
        averageList = Person.averageAgePerGender(personList);
        Assertions.assertEquals(0, averageList[0]);
        Assertions.assertEquals(3, averageList[1]);
    }

    @Test
    public void averagePerAgeOf2MalesIsTheAverageOfBothAnd0AtFemales()
    {
        double[] averageList;
        int age1 = 5;
        int age2 = 7;
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Pepe", age1, Gender.male));
        personList.add(new Person("Jose", age2, Gender.male));
        averageList = Person.averageAgePerGender(personList);
        Assertions.assertEquals((age1 + age2) / 2.0, averageList[0]);
        Assertions.assertEquals(0, averageList[1]);
    }

    @Test
    public void personConstructorThrowsExceptionIfNegativeAge()
    {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Person("", -1, Gender.female));
    }

    @Test
    public void personConstructorThrowsExceptionIfNullName()
    {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Person(null, 0, Gender.female));
    }
}