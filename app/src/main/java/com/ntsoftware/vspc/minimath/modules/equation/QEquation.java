package com.ntsoftware.vspc.minimath.modules.equation;

import java.util.Arrays;

public class QEquation {

    private double a;

    private double b;

    private double c;

    public QEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return (b*b) - 4 * a * c;
    }

    public double[] getXs() {
        double D = getDiscriminant();

        if(D > 0) {
            double x1 = ((-1) * b + Math.sqrt(D))/ 2 * a;
            double x2 = ((-1) * b - Math.sqrt(D))/ 2 * a;
            return new double[] {x1,x2};
        } else if (D == 0) {
            double x = (-1) * (b / (2 * a));
            return new  double[] {x};
        }
        else {
            return new double[] {};
        }

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "QEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", Discriminant=" + getDiscriminant() +
                ", Xs=" + Arrays.toString(getXs()) +
                '}';
    }
}
