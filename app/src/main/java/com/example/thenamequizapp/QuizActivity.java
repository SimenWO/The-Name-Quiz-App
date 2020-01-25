package com.example.thenamequizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView correctAnswersText;
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
        correctAnswersText = findViewById(R.id.correctAnswersText);

        images = ((Questions) this.getApplication()).getImages();
        names = ((Questions) this.getApplication()).getNames();

        startQuiz();


        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNumber < images.size() - 1) {
                    if (checkAnswerButton.getText().toString() == "next") {
                        nextQuestion();
                    } else {
                        checkAnswer();
                    }
                } else {
                    finished();
                }
            }
        });

    }

    public void startQuiz() {
        imageOfPerson.setImageDrawable(images.get(questionNumber));
    }

    public void checkAnswer() {
        if (names.get(questionNumber).toLowerCase().equals(nameInput.getText().toString().toLowerCase())) {
            score++;
            nextQuestion();
        } else {
            correctAnswersText.setText(names.get(questionNumber));
            checkAnswerButton.setText("next");
            System.out.println(names.get(questionNumber).toLowerCase() + " " + nameInput.getText().toString().toLowerCase());
        }
    }


    public void finished() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void nextQuestion() {
        questionNumber++;
        nameInput.setText("");
        correctAnswersText.setText("");
        checkAnswerButton.setText("Check Answer");
        imageOfPerson.setImageDrawable(images.get(questionNumber));

    }
}
