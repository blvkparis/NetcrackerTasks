package ru.ncedu.popkov.color;

public class BlackImpl implements Black {
    private String color;

    @Override
    public String setColor(String color) {
        this.color = color;
        return color;
    }

    @Override
    public boolean isBlack() {
        if (color.equalsIgnoreCase("black")) {
            System.out.println("It's black");
            return true;
        } else {
            System.out.println("It isn’t black");
            return false;
        }
    }
}
