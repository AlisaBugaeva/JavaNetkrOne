package com.mycompany;

import com.mycompany.ball.Ball;
import com.mycompany.ball.Container;
import com.mycompany.book.Author;
import com.mycompany.book.Book;
import com.mycompany.figures.Circle;
import com.mycompany.figures.MyPoint;
import com.mycompany.figures.MyTriangle;
import com.mycompany.figures.Rectangle;
import com.mycompany.maths.MyComplex;
import com.mycompany.maths.MyPolynomial;
import com.mycompany.work.Employee;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println(circle.getArea());
        System.out.println("----------------------");

        Rectangle rectangle = new Rectangle(4,5);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        System.out.println("----------------------");

        Employee employee = new Employee(1,"Alisa", "Bugaeva", 250000);
        System.out.println(employee.getName());
        System.out.println(employee.getAnnualSalary());
        System.out.println(employee.raiseSalary(10));
        System.out.println(employee.toString());
        System.out.println("----------------------");


        MyPoint a = new MyPoint(2,3);
        MyPoint b = new MyPoint(5,7);
        double[] m=a.getXY();
        System.out.println(m[0]+" "+m[1]);
        System.out.println(a.toString());
        System.out.println(a.distance());
        System.out.println(a.distance(4,5));
        System.out.println(a.distance(b));
        a.setXY(7,8);
        System.out.println(a.getX()+" "+ a.getY());
        System.out.println("----------------------");


        MyPoint c = new MyPoint(1,0);
        MyTriangle t1 = new MyTriangle(a,b,c);
        System.out.println(t1.getType());
        a.setXY(-2,3);
        b.setXY((3*Math.sqrt(3)),(Math.sqrt(3))*2);
        c.setXY(2,-3);
        System.out.println(t1.getType());
        a.setXY(0,3);
        b.setXY(-2,-3);
        c.setXY(-6,1);
        System.out.println(t1.getType());
        System.out.println("----------------------");

        MyComplex c1= new MyComplex(4,-5);
        MyComplex c2= new MyComplex(2,3);
        System.out.println(c1);
        System.out.println(c1.add(c2));
        System.out.println(c1.subtract(c2));
        System.out.println(c1.multiply(c2));
        System.out.println(c1.divide(c2));
        System.out.println("c1="+ c1);
        System.out.println("c2="+c2);
        MyComplex c3=c1.addNew(c2);
        System.out.println(c3);
        MyComplex c4=c1.subtractNew(c2);
        System.out.println(c4);
        System.out.println("c3="+c3+" c4="+c4);
        System.out.println("----------------------");

        Ball b1 = new Ball(10,12,2,3,-45);
        Container cont = new Container(2,2,10,12);
        System.out.println(b1.toString());
        System.out.println(cont.toString());
        System.out.println(cont.collides(b1));
        b1.move();
        System.out.println(b1.toString());
        b1.reflectHorizontal();
        System.out.println(b1.toString());
        System.out.println(cont.collides(b1));
        System.out.println("----------------------");

        Author n1 = new Author("Tom", "tom@mail.ru", 'm');
        Author n2 = new Author("Mary", "mary@mail.ru", 'f');
        Author n3 = new Author("Jack", "jack@mail.ru", 'm');
        Book book1 = new Book("Hollywood",280.5,12,n1,n2,n3);
        System.out.println(book1);
        System.out.println(book1.getAuthorNames());
        book1.setPrice(3000);
        System.out.println(book1);
        System.out.println("----------------------");

        MyPolynomial p1 = new MyPolynomial(4,2,7,5);
        MyPolynomial p2 = new MyPolynomial(2,3);
        System.out.println(p1);
        System.out.println(p1.getDegree());
        MyPolynomial p3= p1.multiply(p2);
        System.out.println(p3);
        MyPolynomial p4= p1.add(p2);
        System.out.println(p4);
        MyPolynomial p5 = new MyPolynomial(-2,-5,1);
        System.out.println(p5);


    }
}
