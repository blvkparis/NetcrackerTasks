package ru.ncedu.popkov.voice;

/**
 * Class with voice of a dog
 */
public class Dog implements Voice {
    @Override
    public String voice() {
        return "Woof";
    }
}
