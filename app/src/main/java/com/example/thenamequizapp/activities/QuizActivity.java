package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thenamequizapp.Questions;
import com.example.thenamequizapp.Person;
import com.example.thenamequizapp.R;

import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.content.Intent;

import java.util.Collections;

import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;


public class QuizActivity extends AppCompatActivity {

    TextView correctAnswersText;
    EditText nameInput;
    Button checkAnswerButton;
    ImageView imageOfPerson;
    TextView scoreoutof;

    private ArrayList<Person> people = new ArrayList<>();


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
        scoreoutof = findViewById(R.id.scoreoutof);

        /**
         * Fetches the lists from the global class.
         */
        people = ((Questions) this.getApplication()).getPeople();

        /**
         * Shuffles the list
         */
        Collections.shuffle(people);


        amountOfQuestions = people.size();

        /**
         * Sets the first image to start the quiz.
         */
        startQuiz();

        /**
         * CheckAnswerButton.
         */
        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameInput.getText().toString().equals("")) {
                    if (questionNumber < people.size()) {
                        if (checkAnswerButton.getText().toString() == "next") {
                            nextQuestion();
                        } else {
                            checkAnswer();
                        }
                    } else {
                        if (nameInput.getText().toString().toLowerCase().equals(people.get(questionNumber).getName().toLowerCase())) {

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

    /**
     * Sets the first image to start the quiz.
     */
    public void startQuiz() {
        imageOfPerson.setImageDrawable(people.get(questionNumber).getImage());
        scoreoutof.setText("Score: " + score + "/" + people.size());
    }

    /**
     * Function for checking weather an answer is correct.
     * If image matches the name inputted by the user the score is increased and the next question is showed.
     */
    public void checkAnswer() {
        if (people.get(questionNumber).getName().toLowerCase().equals(nameInput.getText().toString().toLowerCase())) {
            score++;
            correctAnswersText.setText("Correct!");
            correctAnswersText.setTextColor(Color.GREEN);
            checkAnswerButton.setText("next");
        } else {
            correctAnswersText.setText("Wrong! " + people.get(questionNumber).getName());
            correctAnswersText.setTextColor(Color.RED);
            checkAnswerButton.setText("next");
        }
    }

    /**
     * Function that starts the new activity and sends with the score and the amount of questions.
     */
    public void finished() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("amount", amountOfQuestions);
        startActivity(intent);
    }

    /**
     * Function for viewing the next question.
     */
    public void nextQuestion() {
        questionNumber++;
        nameInput.setText("");
        correctAnswersText.setText("");
        scoreoutof.setText("Score: " + score + "/" + people.size());
        checkAnswerButton.setText("Check Answer");

        if (questionNumber > people.size() - 1) {
            finished();
        } else {
            imageOfPerson.setImageDrawable(people.get(questionNumber).getImage());
        }
    }

    /**
     * when ResultActivity is poped (because the user wanted to restart the quiz), the activity is re-created.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}
