package ru.ncedu.popkov.address;

import java.time.LocalDate;
import java.util.ArrayList;


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

        /*System.out.println("Task 1:");
        Person.searchBySurname();
        //Task_2
        System.out.println("\n\nTask 2:");
        findHumanByAddressAttribute(people, "city", "moscow");
        //Task_3
        System.out.println("\n\nTask 3:");
        findPeopleAmongDates(people, "2000-01-01", "2021-04-02");
        //Task_4
        System.out.println("\n\nTask 4:");
        findElderHuman(people);
        //Task_5
        System.out.println("\n\nTask 5:");
        findPeopleByCommonStreet(people);*/
    }



}
