package com.example.thenamequizapp;

import android.graphics.Bitmap;

public class Person {

    private String name;
    private Bitmap image;

    Person(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }
}
