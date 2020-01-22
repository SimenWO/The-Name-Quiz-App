package com.example.thenamequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class QuizActivity extends AppCompatActivity {

    EditText nameInput;
    Button checkAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nameInput = findViewById(R.id.nameInput);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);


    }
}
