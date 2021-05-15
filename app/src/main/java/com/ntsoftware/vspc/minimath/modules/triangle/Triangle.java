package com.ntsoftware.vspc.minimath.modules.triangle;

public class Triangle {

    private double side_a;

    private double side_b;

    private double side_c;

    public static float getSquare(int a, int h) {
        return (a*h) / 2f;
    }

    public Triangle() {
    }

    public Triangle(float side_a, float side_b, float side_c) {

        this.side_a = side_a;

        this.side_b = side_b;

        this.side_c = side_c;
    }

    public double getPerimeter() {
        return side_a + side_b + side_c;
    }

    public double getSquare() {
        double p = getPerimeter() / 2f;
        return Math.sqrt(p * ((p - side_a) * (p - side_b) * (p - side_c)));
    }

    public double getSide_a() {
        return side_a;
    }

    public void setSide_a(double side_a) {
        this.side_a = side_a;
    }

    public double getSide_b() {
        return side_b;
    }

    public void setSide_b(double side_b) {
        this.side_b = side_b;
    }

    public double getSide_c() {
        return side_c;
    }

    public void setSide_c(double side_c) {
        this.side_c = side_c;
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "side_a=" + side_a +
                ", side_b=" + side_b +
                ", side_c=" + side_c +
                ", Perimeter=" + getPerimeter() +
                ", Square=" + getSquare() +
                '}';
    }
}
