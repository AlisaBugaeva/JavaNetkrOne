package com.mycompany.figures;

public class MyTriangle {
    private MyPoint v1 ;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(double x1, double y1,double x2, double y2,double x3, double y3 ){
        v1.setX(x1);
        v1.setY(y1);
        v2.setX(x2);
        v2.setY(y2);
        v3.setX(x3);
        v3.setY(y3);
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=(" + v1.getY() +","+v1.getY()+
                "), v2=(" + v2.getX()+","+v2.getY() +
                "), v3=(" + v3.getX()+","+v3.getY() +
                ")]";
    }

    public double getPerimeter(){
        return v1.distance(v2)+ v2.distance(v3)+v3.distance(v1);
    }

    public String getType() {
        double epsilon = 5.96e-08;
        enum answer {EQUILATERAL, ISOSCELES, SCALENE}
        if (Math.abs(v1.distance(v2) / v1.distance(v3) - 1) < epsilon && Math.abs(v1.distance(v2) / v2.distance(v3) - 1) < epsilon) {
            return answer.EQUILATERAL.name();
        }
        else if(Math.abs(v1.distance(v2) / v1.distance(v3) - 1) < epsilon|| Math.abs(v1.distance(v2) / v2.distance(v3) - 1) < epsilon|| Math.abs(v2.distance(v3) / v1.distance(v3) - 1) < epsilon){
            return answer.ISOSCELES.name();
        }
        else{return answer.SCALENE.name();}
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof MyTriangle)) return false;

        MyTriangle myTriangle = (MyTriangle) obj;//делаем downcast

        return this.v1.equals(myTriangle.v1)
                && this.v2.equals(myTriangle.v2)
                && this.v3.equals(myTriangle.v3);
    }


    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31*result+v1.hashCode();
        result = 31*result+v2.hashCode();
        result = 31*result+v3.hashCode();

        return result;

    }
}
