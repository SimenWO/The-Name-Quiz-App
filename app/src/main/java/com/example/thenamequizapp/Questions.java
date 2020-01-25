package com.example.thenamequizapp;


import android.graphics.drawable.Drawable;
import android.app.Application;

import java.util.ArrayList;

public class Questions extends Application {

    private ArrayList<Drawable> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    /**
     * Return ArrayList of the images.
     *
     * @return
     */
    public ArrayList<Drawable> getImages() {
        return images;
    }

    /**
     * Return ArrayList of the names.
     *
     * @return
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * Function for adding an image to the list.
     *
     * @param image
     */
    public void addImage(Drawable image) {
        images.add(image);
    }

    /**
     * Function for adding a name to the list.
     *
     * @param name
     */
    public void addName(String name) {
        names.add(name);
    }

    /**
     * Function for deleting an image from the list given an index.
     *
     * @param index
     */
    public void deleteImage(int index) {
        images.remove(index);
    }

    /**
     * Function for deleting a name from the list given an index.
     *
     * @param index
     */
    public void deleteName(int index) {
        names.remove(index);
    }

    /**
     * Function for getting list count.
     *
     * @return list length
     */
    public int getCount() {
        return images.size();
    }
}
