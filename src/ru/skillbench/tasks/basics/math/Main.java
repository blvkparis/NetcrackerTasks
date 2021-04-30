package ru.skillbench.tasks.basics.math;

public class Main {
    public static void main(String[] args) {
        ComplexNumberImpl arg1 = new ComplexNumberImpl(5.0, 5.0);
        ComplexNumberImpl arg2 = new ComplexNumberImpl(5, 5);
        ComplexNumberImpl arg3 = new ComplexNumberImpl("-1.0+5.0i");

        //ComplexNumber z = arg1.copy().multiply(arg2).add(arg1.negate());

        System.out.println(arg1.equals(arg2));
        System.out.println(arg1 == arg2);
    }
}
