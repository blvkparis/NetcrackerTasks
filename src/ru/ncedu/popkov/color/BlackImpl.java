package ru.ncedu.popkov.color;

/**
 * BlackImpl class that implements {@link Black} interface methods
 */
public class BlackImpl implements Black {
    //String field for color
    private String color;

    /**
     * Method that set the color for the class
     * @param color which color to set
     * @return color
     */
    @Override
    public String setColor(String color) {
        this.color = color;
        return color;
    }

    /**
     * Method that checks if color of object equals "black"
     * @return true if color is black, otherwise false
     */
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
