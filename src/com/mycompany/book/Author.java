package com.mycompany.book;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ']';
    }

    public String getName() {
        return name;
    }

       @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;

        if(!(obj instanceof Author)) return false;

        Author author = (Author) obj;//делаем downcast

        return this.name.equals(author.name)
                && this.email.equals(author.email)
                && this.gender==author.gender;
    }

    @Override
    public int hashCode() {
        int result = 17;//пишем простое число

        result = 31*result+(int)gender;
        result = 31*result+name.hashCode();
        result = 31*result+email.hashCode();

        return result;

    }
}
