package ru.ncedu.popkov.address;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The main class of the program
 *
 * @author Anton Popkov
 */
public class AddressMain {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Person person1 = new Person("Sidorov", "Sidor",
                LocalDate.of(1974, 7, 28),
                Address.generateAddress());

        Person person2 = new Person("Shevelev", "Alex",
                LocalDate.of(1999, 10, 24),
                Address.generateAddress());

        Person person3 = new Person("Konovalov", "Petr",
                LocalDate.of(1960, 3, 27),
                Address.generateAddress());

        Person person4 = new Person("Reznikov", "Maxim",
                LocalDate.of(1958, 1, 15),
                Address.generateAddress());

        Person person5 = new Person("Samilov", "Ivan",
                LocalDate.of(2001, 12, 12),
                Address.generateAddress());

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        //Task1
        System.out.println("Task 1:");
        System.out.println(Person.searchBySurname(people, "Reznikov"));

        //Task2
        System.out.println("\n\nTask 2:");
        System.out.println(Person.searchByCity(people, "Moscow"));

        //Task3
        System.out.println("\n\nTask 3:");
        Person.searchBetweenDates(people, LocalDate.of(1999, 10, 10),
                LocalDate.of(2003, 5, 5));

        //Task4
        System.out.println("\n\nTask 4:");
        System.out.println(Person.findOldest(people));

        //Task5
        System.out.println("\n\nTask 5:");
        Person.findByCommonStreet(people, "Pushkina");
    }
}