package ru.ncedu.popkov.address;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents Person
 *
 * @author Anton Popkov
 */
public class Person {
    private String surname;
    private String name;
    private LocalDate birthDate;
    private Address address;

    public Person(String surname, String name, LocalDate birthDate, Address address) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return surname + " " + name + " - " +  this.address;
    }

    public static Person searchBySurname(ArrayList<Person> persons, String surname) {
        Person targetPerson = null;
        for (Person person : persons) {
            if (person.getSurname().equalsIgnoreCase(surname)) {
                targetPerson = person;
            }
        }
        if (targetPerson == null) {
            System.out.println("No Persons found");
        }
        return targetPerson;
    }

    public static Person searchByCity(ArrayList<Person> persons, String city) {
        Person targetPerson = null;
        for (Person person : persons) {
            if (person.getAddress().getCity().equalsIgnoreCase(city)) {
                targetPerson = person;
            }
        }
        if (targetPerson == null) {
            System.out.println("No Persons found");
        }
        return targetPerson;
    }

    public static void searchBetweenDates(ArrayList<Person> persons, LocalDate date1, LocalDate date2) {
        ArrayList<Person> targetPersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getBirthDate().isAfter(date1) && person.getBirthDate().isBefore(date2)) {
                targetPersons.add(person);
            }
        }
        if (targetPersons.isEmpty()) {
            System.out.println("No Persons found");
        }
        else {
            for (Person person : targetPersons) {
                System.out.println(person + ", Birth Date - " + person.getBirthDate());
            }
        }
    }

    public static Person findYoungest(ArrayList<Person> persons) {
        Person youngest = persons.get(0);
        for (Person person: persons) {
            if (person.getBirthDate().isBefore(youngest.getBirthDate()))
                youngest = person;
        }
        return youngest;
    }

    public static Person findOldest(ArrayList<Person> persons) {
        Person oldest = persons.get(0);
        for (Person person: persons) {
            if (person.getBirthDate().isAfter(oldest.getBirthDate()))
                oldest = person;
        }
        return oldest;
    }

    public static void findByCommonStreet(ArrayList<Person> persons, String street) {
        ArrayList<Person> targetPersons = new ArrayList<>();

        for (Person person : persons) {
            if (person.getAddress().getStreet().equalsIgnoreCase(street)) {
                targetPersons.add(person);
            }
        }
        if (targetPersons.isEmpty()) {
            System.out.println("No Persons found");
        }
        else {
            System.out.println("Founded persons:");
            for (Person person : targetPersons)
                System.out.println(person);
        }
    }
}
