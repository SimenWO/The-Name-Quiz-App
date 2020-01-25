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

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private List<Drawable> images = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        images = ((Questions) this.getApplication()).getImages();
        names = ((Questions) this.getApplication()).getNames();

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerview);

        MyAdapter myAdapter = new MyAdapter(this, names, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this, NewPersonActivity.class);
                startActivity(intent);
            }
        });
    }
}
