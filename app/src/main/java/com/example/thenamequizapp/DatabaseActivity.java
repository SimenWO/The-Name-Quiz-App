package com.example.thenamequizapp;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.content.Intent;

import java.util.ArrayList;

import android.view.View;
import android.os.Bundle;

import java.util.List;


public class DatabaseActivity extends AppCompatActivity {

    private List<Drawable> images = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private RecyclerView recyclerView;
    private FloatingActionButton fab;


    /**
     * When NewPersonActivity is finished() the activity will be recreated.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        /**
         *  Fetches images and names from the global class Questions.
         */
        images = ((Questions) this.getApplication()).getImages();
        names = ((Questions) this.getApplication()).getNames();

        /**
         *  Connecting the fab and the recyclerView.
         */
        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerview);

        /**
         * MyAdapter for handling the RecyclerView.
         */
        MyAdapter myAdapter = new MyAdapter(this, names, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /**
         *  New activity to NewPersonActivity.
         */
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this, NewPersonActivity.class);
                startActivity(intent);
            }
        });
    }
}
