package com.mycompany.figures;

import com.mycompany.book.Author;

public class Circle {

    private double radius=1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius(){
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ']';
    }

    public double getArea(){
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof Circle)) return false;

        Circle circle = (Circle) obj;//делаем downcast

        double epsilon =5.96e-08;


        return Math.abs(this.radius/circle.radius-1) < epsilon
                && this.color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31*result+ (int)(Double.doubleToLongBits(radius)^(Double.doubleToLongBits(radius)>>>32)) ;
        result = 31*result+color.hashCode();


        return result;

    }
}
