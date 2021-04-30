package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {
    private double re;
    private double im;

    public ComplexNumberImpl() {
        re = 0;
        im = 0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String value) {
        set(value);
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return re != 0 && im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        boolean flag = false;
        StringBuilder sbRe = new StringBuilder();
        StringBuilder sbIm = new StringBuilder();
        for (int i = 0; i < value.length() - 1; i++) {
            if (value.charAt(i) == '-') {
                sbRe.append(value.charAt(0));
                continue;
            }
            if (value.charAt(i) != '+' && value.charAt(i) != '-' && !flag) { // && !flag
                sbRe.append(value.charAt(i));
            } else flag = true;

            if (flag)
                sbIm.append(value.charAt(i));
        }

        double newRe, newIm;
        newRe = Double.parseDouble(sbRe.toString());
        newIm = Double.parseDouble(sbIm.toString());

        this.re = newRe;
        this.im = newIm;
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.re, this.im);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (!(other instanceof ComplexNumber)) {
            return false;
        } else {
            ComplexNumber otherComplexNumber = (ComplexNumber) other;
            return (Double.compare(re, otherComplexNumber.getRe()) == 0) && (Double.compare(im,
                    otherComplexNumber.getIm()) == 0);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (re != 0) {
            sb.append(re);
        }

        if (im > 0 && re != 0) {
            sb.append("+");
            sb.append(im);
            sb.append("i");
        } else if ((im < 0 && re != 0) || im > 0 || im < 0) {
            sb.append(im);
            sb.append("i");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(ComplexNumber other) {
        return Double.compare(re * re + im * im, Math.pow(other.getRe(), 2) + (Math.pow(other.getRe(), 2)));
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        re = -1 * re;
        im = -1 * im;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double newRe, newIm;
        newRe = re * arg2.getRe() - im * arg2.getIm();
        newIm = im * arg2.getRe() + re * arg2.getIm();

        this.set(newRe, newIm);
        return this;
    }
}
