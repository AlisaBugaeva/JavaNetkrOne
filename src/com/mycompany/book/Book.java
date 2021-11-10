package com.mycompany.book;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, double price, Author ... authors) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, double price, int qty, Author ... authors) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        String a="Book[" +
                "name='" + name + '\'' +
                ", authors={[";
        String b = "]}, price=" + price +
            ", qty=" + qty +
            ']';
        String c="";
        for(int i=0;i<authors.length-1;i++) {
            c = c+authors[i]+",";
        }
        c=c+authors[authors.length-1];
        return a+c+b;
    }

    public String getAuthorNames(){
        String c="";
        for(int i=0;i<authors.length-1;i++) {
            c = c+authors[i].getName()+",";
        }
        c=c+authors[authors.length-1].getName();
        return c;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && qty == book.qty && Objects.equals(name, book.name) && Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, price, qty);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }
}
