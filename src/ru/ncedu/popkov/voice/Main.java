package ru.ncedu.popkov.voice;

public class Main {
    public static void main(String[] args) {
        Voice cat = new Cat();
        Voice dog = new Dog();
        Voice cow = new Cow();

        System.out.println(cat.voice());
        System.out.println(dog.voice());
        System.out.println(cow.voice());
    }
}
