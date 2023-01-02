package com.example.vacation;


import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String txtTitle;
    private int price;
    private int imageId;

    public Product(int id, String txtTitle, int price, int imageId) {
        this.id = id;
        this.price = price;
        this.txtTitle = txtTitle;
        this.imageId = imageId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTitle() {
        return txtTitle;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }
}
