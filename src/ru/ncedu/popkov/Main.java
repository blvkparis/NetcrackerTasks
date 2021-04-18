package ru.ncedu.popkov;

import ru.ncedu.popkov.color.Black;
import ru.ncedu.popkov.color.BlackImpl;
import ru.ncedu.popkov.extended.ExtendedClass;

public class Main {
    public static void main(String[] args) {
        Black black = new BlackImpl();
        Black yellow = new BlackImpl();

        black.setColor("black");
        yellow.setColor("yellow");

        black.isBlack();
        yellow.isBlack();
    }
}
