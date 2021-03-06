package com.rufflez.helloworld;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by hemanth on 2/5/2015.
 */
public class Product implements Serializable{

    String id;
    String name;
    String Category;
    double price;
    String desc;

    public Product(String id, String name, String category, double price, String desc, Drawable image) {
        this.id = id;
        this.name = name;
        Category = category;
        this.price = price;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    Drawable image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
