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
    int amountOfQuestions = 0;
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

        amountOfQuestions = images.size();
        startQuiz();


        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameInput.getText().toString().equals("")) {
                    if (questionNumber < images.size()) {
                        if (checkAnswerButton.getText().toString() == "next") {
                            nextQuestion();
                        } else {
                            checkAnswer();
                        }
                    } else {
                        if (nameInput.getText().toString().toLowerCase().equals(names.get(questionNumber).toLowerCase())) {

                            finished();
                        } else {
                            checkAnswer();
                            if (checkAnswerButton.getText().toString() == "next") {
                                finished();
                            }
                        }
                    }
                } else {
                    Toast.makeText(QuizActivity.this, "Text box is empty", Toast.LENGTH_SHORT).show();
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
            correctAnswersText.setText("Correct Answer: " + names.get(questionNumber));
            checkAnswerButton.setText("next");
        }
    }


    public void finished() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("amount", amountOfQuestions);
        startActivity(intent);
    }

    public void nextQuestion() {
        questionNumber++;
        nameInput.setText("");
        correctAnswersText.setText("");
        checkAnswerButton.setText("Check Answer");

        if(questionNumber > images.size()-1){
            finished();
        } else {
            imageOfPerson.setImageDrawable(images.get(questionNumber));
        }

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}
