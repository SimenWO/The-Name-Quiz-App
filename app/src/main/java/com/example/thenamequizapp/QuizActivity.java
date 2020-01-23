package com.example.thenamequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    EditText nameInput;
    Button checkAnswerButton;

    private List<Drawable> images = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nameInput = findViewById(R.id.nameInput);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);

        images = ((Questions) this.getApplication()).getImages();
        names = ((Questions) this.getApplication()).getNames();


        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameInput.getText().toString() == "") {
                    System.out.println("Do something here");
                }
            }
        });

    }
}
