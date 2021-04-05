package ru.ncedu.popkov.address;

import java.util.Random;

/**
 * Respresents Address
 *
 * @author Anton Popkov
 */
public class Address {
    private String city;
    private String street;
    private int building;
    private int flat;

    /**
     * Constructor for address
     */
    public Address(String city, String street, int building, int flat) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address: " + city + ", " + street + " street, " + building + ", " + flat;
    }

    public static Address generateAddress() {
        String[] cities = {"Moscow", "St. Petersburg", "Kazan", "Novgorod", "Los Angeles", "Paris"};
        String[] streets = {"Pushkina", "Stolehnikova", "Gagarina", "5th Avenue", "Baker street"};

        Random random = new Random();
        String randomCity = cities[random.nextInt(cities.length)];
        String randomStreet = streets[random.nextInt(streets.length)];
        int randomBuilding = random.nextInt(100 - 1) + 1;
        int randomFlat = random.nextInt(100 - 1) + 1;

        return new Address(randomCity, randomStreet, randomBuilding, randomFlat);
    }
}
