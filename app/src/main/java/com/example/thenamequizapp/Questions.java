package com.example.thenamequizapp;


import android.graphics.drawable.Drawable;
import android.app.Application;

import java.util.ArrayList;

public class Questions extends Application {

    private ArrayList<Person> people = new ArrayList<>();

    /**
     * @param image
     * @param name
     */
    public void addPerson(String id, Drawable image, String name) {
        people.add(new Person(id, image, name));
    }

    /**
     * @return
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * @param index
     */
    public void deletePerson(int index) {
        people.remove(index);
    }


    /**
     * Function for getting list count.
     *
     * @return list length
     */
    public int getCount() {
        return people.size();
    }
}
