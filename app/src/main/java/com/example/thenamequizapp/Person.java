package com.example.thenamequizapp;

import android.graphics.drawable.Drawable;

public class Person {

    Drawable image;
    String name;

    Person(Drawable image, String name){
        this.image = image;
        this.name = name;
    }

    public Drawable getImage(){
        return image;
    }

    public String getName(){
        return name;
    }


}
