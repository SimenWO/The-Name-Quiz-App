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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImages();

        startButton = findViewById(R.id.start);
        manageButton = findViewById(R.id.manage);
        final int count = ((Questions) this.getApplication()).getCount();


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);

                if (count > 0) {
                    startActivity(intent);
                } else {
                    System.out.println("No questions");
                }
            }
        });


        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initImages() {


        ((Questions) this.getApplication()).addImage(getResources().getDrawable(R.drawable.anders));
        ((Questions) this.getApplication()).addImage(getResources().getDrawable(R.drawable.simen));
        ((Questions) this.getApplication()).addImage(getResources().getDrawable(R.drawable.sebastian));

        ((Questions) this.getApplication()).addName("Anders");
        ((Questions) this.getApplication()).addName("Simen");
        ((Questions) this.getApplication()).addName("Sebastian");

    }


}
