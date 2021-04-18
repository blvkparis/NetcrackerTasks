package ru.ncedu.popkov.extended;

import java.util.Objects;

/**
 * Class that has some fields and overridden methods
 *
 * @author Anton Popkov
 */
public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;

    /**
     * Constructor
     *
     * @param b byte field
     * @param i int field
     * @param d double field
     * @param s String field
     */
    public ExtendedClass(byte b, int i, double d, String s) {
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }

    /**
     * Equals method for ExtendedClass objects
     *
     * @param anObject object to compare with
     * @return true if objects are equals, otherwise false
     */
    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (!(anObject instanceof ExtendedClass)) return false;

        ExtendedClass that = (ExtendedClass) anObject;

        if (b != that.b) return false;
        if (i != that.i) return false;
        if (Double.compare(that.d, d) != 0) return false;
        return Objects.equals(s, that.s);
    }

    /**
     * Method that calculate hashCode for an object
     *
     * @return int hashCode
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = b;
        result = 31 * result + i;
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (s != null ? s.hashCode() : 0);
        return result;
    }

    /**
     * Method toString()
     * @return String
     */
    @Override
    public String toString() {
        return "byte: " + b + "\n" +
                "int: " + i + "\n" +
                "double: " + d + "\n" +
                "String: " + s;
    }
}