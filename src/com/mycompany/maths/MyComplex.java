package com.mycompany.maths;

import com.mycompany.figures.MyPoint;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real=real;
        this.imag=imag;
    }

    @Override
    public String toString() {
        if(this.imag<0){
            return "("  + real
                    + imag +
                    "i)";
        }
        else {
            return "(" + real +
                    "+" + imag +
                    "i)";
        }
    }

    public boolean isReal(){
        return this.real != 0;
    }

    public boolean isImaginary(){
        return this.imag != 0;
    }

    public boolean equals(double real, double imag){
        return this.real == real && this.imag == imag;
    }

   /* public boolean equals(MyComplex another){
        return this.real == another.getReal() && this.imag == another.getImag();
    }*/


    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof MyComplex)) return false;

        MyComplex myComplex = (MyComplex) obj;//делаем downcast

        double epsilon =5.96e-08;


        return Math.abs(this.real/myComplex.real-1) < epsilon
                && Math.abs(this.imag/myComplex.imag-1) < epsilon;
    }

    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31*result+ (int)(Double.doubleToLongBits(real)^(Double.doubleToLongBits(real)>>>32)) ;
        result = 31*result+ (int)(Double.doubleToLongBits(imag)^(Double.doubleToLongBits(imag)>>>32)) ;


        return result;

    }


    public double magnitude(){
        return Math.sqrt(Math.pow(this.real,2)+Math.pow(this.imag,2));
    }

    public double argument(){
        return Math.atan(imag/real);
    }

    public MyComplex add(MyComplex right){
        this.real+=right.getReal();
        this.imag+=right.getImag();
        return this;
    }

    public MyComplex addNew (MyComplex right){
        MyComplex addComplex = new MyComplex();
        addComplex.real=this.real+right.getReal();
        addComplex.imag= this.imag+right.getImag();
        return addComplex;
    }

    public MyComplex subtract(MyComplex right){
        this.real-=right.getReal();
        this.imag-=right.getImag();
        return this;
    }

    public MyComplex subtractNew (MyComplex right){
        MyComplex subtractComplex = new MyComplex();
        subtractComplex.real=this.real-right.getReal();
        subtractComplex.imag= this.imag-right.getImag();
        return subtractComplex;
    }

    public MyComplex multiply(MyComplex right){
        double r =this.real*right.getReal()-this.imag*right.imag;
        double i =this.real*right.getImag()+this.imag*right.getReal();
        this.real=r;
        this.imag=i;
        return this;
    }

    public MyComplex divide(MyComplex right){
        double r =(this.real*right.getReal()+this.imag*right.imag)/(Math.pow(right.real,2)+Math.pow(right.imag,2));
        double i =(this.imag*right.getReal()-this.real*right.getImag())/(Math.pow(right.real,2)+Math.pow(right.imag,2));
        this.real=r;
        this.imag=i;
        return this;
    }

    public MyComplex conjugate(){
        MyComplex conj = new MyComplex();
        conj.real=this.real;
        conj.imag=-this.imag;
        return conj;
    }




}
