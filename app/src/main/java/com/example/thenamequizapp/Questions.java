package com.example.thenamequizapp;

import android.app.Application;

import java.util.ArrayList;

public class Questions extends Application {

    private ArrayList<Integer> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    public Questions(ArrayList<Integer> images, ArrayList<String> names) {
        this.images = images;
        this.names = names;

    }

    public Questions() {
        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add(R.drawable.sebastian);
        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add(R.drawable.sebastian);
        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add(R.drawable.sebastian);

        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public void addImage(int image) {
        images.add(image);
    }

    public void addName(String name) {
        names.add(name);
    }

    public void deleteImage(int index){
        images.remove(index);
    }

    public void deleteName(int index){
        names.remove(index);
    }
}
