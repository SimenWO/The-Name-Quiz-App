package com.example.thenamequizapp;

import android.graphics.drawable.Drawable;

public class Person {

    String id;
    Drawable image;
    String name;

    /**
     * Constructor for the Person class
     *
     * @param image
     * @param name
     */
    Person(String id, Drawable image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    /**
     * Get the ID
     *
     * @return id
     */
    public String getId() {
        return id;
    }


    /**
     * Get the image
     *
     * @return image
     */
    public Drawable getImage() {
        return image;
    }

    /**
     * Get the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }


}
