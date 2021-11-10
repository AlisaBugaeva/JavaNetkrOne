package com.mycompany.maths;

import java.util.Arrays;

public class MyPolynomial {
    double [] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String polinom =  coeffs[coeffs.length-1]+ "x^" + (coeffs.length-1);
        for(int i=coeffs.length-2;i>1;i--) {
            if(coeffs[i]<0){
                polinom = polinom + coeffs[i] + "x^" + i;
            }
            else {
                polinom = polinom+ "+" + coeffs[i] + "x^" + i ;
            }
        }
        if(coeffs[1]>=0) {
            polinom +="+";
        }
        polinom = polinom + coeffs[1]+"x" ;
        if(coeffs[0]>=0) {
            polinom +="+";
        }
        polinom = polinom + coeffs[0] ;
        return polinom;

    }

    public double evaluate(double x){
        double ans=0;
        for(int i=coeffs.length-1;i>0;i--) {
            ans = ans + coeffs[i]*Math.pow(x,i);
        }
        return ans+coeffs[0];
    }

    public MyPolynomial add (MyPolynomial right){
        MyPolynomial max;
        MyPolynomial min;
        if(this.getDegree()> right.getDegree()){
            max = new MyPolynomial(this.coeffs);
            min = new MyPolynomial(right.coeffs);
        }
        else{
            min = new MyPolynomial(this.coeffs);
            max = new MyPolynomial(right.coeffs);
        }
        double [] koef = new double[max.getDegree()+1];
        for(int i =max.getDegree();i>=0;i--){
            if(i>min.getDegree()){
                koef[i]=max.coeffs[i];
            }
            else{
                koef[i]=max.coeffs[i]+min.coeffs[i];
            }
        }
        MyPolynomial addPolynomial = new MyPolynomial(koef);
        return addPolynomial;


    }

    public MyPolynomial multiply (MyPolynomial right){
        double [] koef= new double[this.getDegree()+right.getDegree()+1];
        for(int i=0; i<this.coeffs.length;i++){
            for (int j=0;j<right.coeffs.length;j++){
                koef[i+j]+=this.coeffs[i]* right.coeffs[j];
            }
        }
        MyPolynomial multiPolynomial = new MyPolynomial(koef);
        return multiPolynomial;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }
}
