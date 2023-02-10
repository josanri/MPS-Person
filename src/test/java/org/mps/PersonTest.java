package org.mps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonTest {

    @Test
    public void averagePerAgeThrowsExceptionIfNullListIsGiven()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(null));
    }

    @Test
    public void averagePerAgeThrowsExceptionIfEmptyListIsGiven()
    {
        List<Person> list = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> Person.averageAgePerGender(list));
    }

    @Test
    public void averagePerAgeOf1MaleIsThatAge()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepe", 3, Gender.male));
        averageList = Person.averageAgePerGender(personList);

        double expectedValue = 3.0;
        double actualValue = averageList[0];

        Assertions.assertEquals(expectedValue, actualValue);
        Assertions.assertEquals(0, averageList[1]);
    }

    @Test
    public void averagePerAgeOf1MaleIs0AtFemales()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepe", 3, Gender.male));
        averageList = Person.averageAgePerGender(personList);

        double expectedValue = 0.0;
        double actualValue = averageList[1];

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void averagePerAgeDoesNotThrowsExceptionOnExpectedIntegerOverflow()
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Antonia", Integer.MAX_VALUE, Gender.female));
        personList.add(new Person("Pepa", 3, Gender.female));

        Assertions.assertDoesNotThrow(() -> Person.averageAgePerGender(personList));
    }

    @Test
    public void averagePerAgeOfFemales_11_3_3_Returns_17_DividedBy_3()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepa", 11, Gender.female));
        personList.add(new Person("Antonia", 3, Gender.female));
        personList.add(new Person("Julia", 3, Gender.female));
        averageList = Person.averageAgePerGender(personList);

        double expectedValue = 17.0 / 3.0;
        double actualValue = averageList[1];

        Assertions.assertEquals(expectedValue, actualValue);
    }


    @Test
    public void averagePerAgeOfMales_3_10_10_Returns_23_DividedBy_3()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepe", 3, Gender.male));
        personList.add(new Person("Antonio", 10, Gender.male));
        personList.add(new Person("Julio", 10, Gender.male));
        averageList = Person.averageAgePerGender(personList);

        double expectedValue = 23.0 / 3.0;
        double actualValue = averageList[0];

        Assertions.assertEquals(expectedValue, actualValue);

    }
    @Test
    public void averagePerAgeOfMalesAndFemalesExample()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepe", 3, Gender.male));
        personList.add(new Person("Antonio", 10, Gender.male));
        personList.add(new Person("Julio", 10, Gender.male));
        personList.add(new Person("Pepa", 11, Gender.female));
        personList.add(new Person("Antonia", 3, Gender.female));
        personList.add(new Person("Julia", 3, Gender.female));
        averageList = Person.averageAgePerGender(personList);

        double expectedValueAt0 = 23.0 / 3.0;
        double actualValueAt0 = averageList[0];
        double expectedValueAt1 = 17.0 / 3.0;
        double actualValueAt1 = averageList[1];

        Assertions.assertEquals(expectedValueAt0, actualValueAt0);
        Assertions.assertEquals(expectedValueAt1, actualValueAt1);

    }

    @Test
    public void averagePerAgeOf1FemaleIsThatAgeAnd0AtMales()
    {
        double[] averageList;
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Pepa", 3, Gender.female));
        averageList = Person.averageAgePerGender(personList);

        double expectedValue = 3.0;
        double actualValue = averageList[1];

        Assertions.assertEquals(expectedValue, actualValue);

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

        double expectedValue = (age1 + age2) / 2.0;
        double actualValue = averageList[0];

        Assertions.assertEquals(expectedValue, actualValue);
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

    @Test
    public void maleGetter()
    {
        String name = "Pepe";
        int age = 15;
        Gender gender = Gender.male;

        Person person = new Person(name, age, gender);

        Assertions.assertEquals(name, person.getName());
        Assertions.assertEquals(age, person.getAge());
        Assertions.assertEquals(gender, person.getGender());
    }

    @Test
    public void femaleGetter()
    {
        String name = "Pepa";
        int age = 35;
        Gender gender = Gender.female;

        Person person = new Person(name, age, gender);

        Assertions.assertEquals(name, person.getName());
        Assertions.assertEquals(age, person.getAge());
        Assertions.assertEquals(gender, person.getGender());
    }
}