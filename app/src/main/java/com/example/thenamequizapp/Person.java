package com.example.thenamequizapp;

import android.graphics.drawable.Drawable;

public class Person {

    private String name;
    private int image;

    Person(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
