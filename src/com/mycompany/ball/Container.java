package com.mycompany.ball;

public class Container {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Container(int x, int y, int width, int height) {
       x1 = x;
       y1= y;
       x2 = x + width;
       y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2-x1;
    }

    public int getHeight(){
        return y2-y1;
    }

    public boolean collides(Ball ball){
        return ball.getX() + ball.getRadius() <= x2 && ball.getY() + ball.getRadius() <= y2;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 +
                "," + y1 +
                "),(" + x2 +
                "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof Container)) return false;

        Container container = (Container) obj;//делаем downcast

        return this.x1==container.x1
                && this.x2 == container.x2
                && this.y1==container.y1
                && this.y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31 * result + x1;
        result = 31 * result + x2;
        result = 31 * result + y1;
        result = 31 * result + y2;

        return result;
    }
}
