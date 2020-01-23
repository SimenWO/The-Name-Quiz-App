package com.example.thenamequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton startButton;
    Button manageButton;
    private ArrayList<Integer> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add( R.drawable.sebastian);
        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add( R.drawable.sebastian);
        images.add(R.drawable.anders);
        images.add(R.drawable.simen);
        images.add( R.drawable.sebastian);

        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");
        names.add("Anders");
        names.add("Simen");
        names.add("Sebastian");



        startButton = findViewById(R.id.start);
        manageButton = findViewById(R.id.manage);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });


        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                intent.putIntegerArrayListExtra("images",images);
                intent.putStringArrayListExtra("names",names);
                startActivity(intent);
            }
        });

    }


}
