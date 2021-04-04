package ru.ncedu.popkov.equation;

/**
 * Represents a quadratic equation
 *
 * @author Anton Popkov
 *
 */
public class Equation {
    private final double a;
    private final double b;
    private final double c;

    /**
     * Solutions
     */
    private double x1;
    private double x2;

    /**
     * Constructor for quadratic equation with coefficients
     *
     * @param a - coefficient before x^2
     * @param b - coefficient before x
     * @param c - free coefficient
     */
    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Solving method
     *
     * @return String with solutions for equation
     */
    public String solve() {
        Discriminant discriminant = new Discriminant();
        double D = discriminant.getDiscriminant(this);

        if (this.a == 0) return "Equation is not quadratic";
        if (D < 0) return "Equation has no rational solutions";
        else if (D >= 0) {
            x1 = (-1 * b + Math.sqrt(D)) / (2 * a);
            x2 = (-1 * b - Math.sqrt(D)) / (2 * a);
        }
        return "Solutions: " + x1 + ", " + x2;
    }

    /**
     * Represents a discriminant.
     */
    public static class Discriminant {
        public double getDiscriminant(Equation eq) {
            return Math.pow(eq.b, 2) - 4 * eq.a * eq.c;
        }
    }
}