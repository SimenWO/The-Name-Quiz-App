package com.example.thenamequizapp;

import android.app.Application;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Questions extends Application {

    private ArrayList<Drawable> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    public Questions(ArrayList<Drawable> images, ArrayList<String> names) {
        this.images = images;
        this.names = names;

    }

    public Questions() {

        /*
        images.add(getResources().getDrawable(R.drawable.anders));
        images.add(getResources().getDrawable(R.drawable.simen));
        images.add(getResources().getDrawable(R.drawable.sebastian));
        images.add(getResources().getDrawable(R.drawable.anders));
        images.add(getResources().getDrawable(R.drawable.simen));
        images.add(getResources().getDrawable(R.drawable.sebastian));
        images.add(getResources().getDrawable(R.drawable.anders));
        images.add(getResources().getDrawable(R.drawable.simen));
        images.add(getResources().getDrawable(R.drawable.sebastian));

        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
    */

    }

    public ArrayList<Drawable> getImages() {
        return images;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setImages(ArrayList<Drawable> images) {
        this.images = images;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public void addImage(Drawable image) {
        images.add(image);
    }

    public void addName(String name) {
        names.add(name);
    }

    public void deleteImage(int index) {
        images.remove(index);
    }

    public void deleteName(int index) {
        names.remove(index);
    }
}
