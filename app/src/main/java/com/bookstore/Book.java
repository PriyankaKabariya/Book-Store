package com.bookstore;

public class Book {

    int Image;
    String Name;
    String Des;
    String Price;

    public Book(int image, String name, String des, String price) {
        Image = image;
        Name = name;
        Des = des;
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}

