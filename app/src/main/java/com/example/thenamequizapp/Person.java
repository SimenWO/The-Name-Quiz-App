package com.example.thenamequizapp;

import android.graphics.drawable.Drawable;

import java.util.UUID;


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
    Person(Drawable image, String name) {
        this.id = UUID.randomUUID().toString();
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
