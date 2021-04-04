package ru.ncedu.popkov.equation;

/**
 * The main class for starting Equation task
 *
 * @author Anton Popkov
 */
public class Main {

    public static void main(String[] args) {
	    Equation equation = new Equation(3, -14, -5);
        System.out.println(equation.solve());
    }
}
