package com.mycompany.ball;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float)(speed*Math.cos(direction));
        this.yDelta =(float)(speed*Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        this.x+=this.xDelta;
        this.y+=this.yDelta;
    }

    public void reflectHorizontal(){
        this.xDelta=-this.xDelta;
    }

    public void reflectVertical(){
        this.yDelta=-this.yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x +
                "," + y +
                "), speed=("  + xDelta +
                "," + yDelta + ")]";
    }

   @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof Ball)) return false;

        Ball ball = (Ball) obj;//делаем downcast

       double epsilon =5.96e-08;

       return Math.abs(this.x/ball.x-1) < epsilon
               && Math.abs(this.y/ball.y-1) < epsilon
               && this.radius==ball.radius
               &&Math.abs(this.xDelta/ball.xDelta-1) < epsilon
               && Math.abs(this.yDelta/ball.yDelta-1) < epsilon;
    }

    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31 * result + radius;
        result = 31 * result + Float.floatToIntBits(this.x);
        result = 31 * result + Float.floatToIntBits(this.y);
        result = 31 * result + Float.floatToIntBits(this.xDelta);
        result = 31 * result + Float.floatToIntBits(this.yDelta);


        return result;
    }
}
