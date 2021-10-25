package com.mycompany.figures;

public class MyPoint {
    private double x=0;
    private double y=0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getXY(){
        double[] XY=new double[2];
        XY[0]=x;
        XY[1]=y;
        return XY;
    }

    public void setXY(double x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    public double distance(double x,double y){
        return Math.sqrt(Math.pow((this.x-x),2)+Math.pow((this.y-y),2));
    }

    public double distance(MyPoint another){
        return Math.sqrt(Math.pow((this.x-another.getX()),2)+Math.pow((this.y-another.getY()),2));
    }

    public double distance(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
}
