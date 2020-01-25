package com.example.thenamequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    EditText nameInput;
    Button checkAnswerButton;
    ImageView imageOfPerson;

    private List<Drawable> images = new ArrayList<>();
    private List<String> names = new ArrayList<>();

    int score = 0;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nameInput = findViewById(R.id.nameInput);
        checkAnswerButton = findViewById(R.id.checkAnswerButton);
        imageOfPerson = findViewById(R.id.imageofperson);

        images = ((Questions) this.getApplication()).getImages();
        names = ((Questions) this.getApplication()).getNames();

        startQuiz();


        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameInput.getText().toString().length() > 1) {
                    if (questionNumber < images.size()) {
                        nextQuestion();
                    } else {
                      finished();
                    }
                } else {
                    Toast.makeText(QuizActivity.this, "No text found",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void startQuiz() {
        imageOfPerson.setImageDrawable(images.get(questionNumber));
    }

    public boolean checkAnswer() {
        if (names.get(questionNumber).toLowerCase() == nameInput.getText().toString().toLowerCase()) {
            return true;
        } else {
            return false;

        }
    }

    public void finished(){
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void nextQuestion() {
        nameInput.setText("");
        questionNumber++;
        imageOfPerson.setImageDrawable(images.get(questionNumber));

    }
}
