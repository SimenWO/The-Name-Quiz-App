package com.example.thenamequizapp;

import android.graphics.drawable.Drawable;

public class Person {

    Drawable image;
    String name;

    /**
     * Constructor for the Person class
     *
     * @param image
     * @param name
     */
    Person(Drawable image, String name) {
        this.image = image;
        this.name = name;
    }

    /**
     * Get the image
     *
     * @return
     */
    public Drawable getImage() {
        return image;
    }

    /**
     * Get the name
     *
     * @return
     */
    public String getName() {
        return name;
    }


}
