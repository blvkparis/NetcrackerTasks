package ru.ncedu.popkov.equation;

/**
 * The main class for starting Equation task
 *
 * @author Anton Popkov
 */
public class Main {

    public static void main(String[] args) {
	    Equation equation = new Equation(14, 15, 1);
        System.out.println(equation.solve());
    }
}
