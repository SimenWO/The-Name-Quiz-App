package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import com.example.thenamequizapp.Questions;
import com.example.thenamequizapp.R;


public class MainActivity extends AppCompatActivity {

    ImageButton startButton;
    Button manageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startButton = findViewById(R.id.start);
        manageButton = findViewById(R.id.manage);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = pref.getString("name", "");


        /**
         * If a name is not in the shared preferences the user will be taken to a name activity
         */
        if (name.equals("")) {
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            startActivity(intent);
        }

        /**
         * Get the amount of people in the database
         */
        final int count = ((Questions) this.getApplication()).getCount();

        /**
         * If the count is 0 then all of the names and images will be added to the global lists.
         */
        if (count == 0) {
            addQuestions();
        }

        /**
         *  Starts new activity.
         */
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });


        /**
         *  Starts new activity.
         */
        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * Add images and names of the people in our group.
     */
    public void addQuestions() {
        ((Questions) this.getApplication()).addPerson("", getResources().getDrawable(R.drawable.anders), "Anders");
        ((Questions) this.getApplication()).addPerson("", getResources().getDrawable(R.drawable.simen), "Simen");
        ((Questions) this.getApplication()).addPerson("", getResources().getDrawable(R.drawable.sebastian), "Sebastian");

    }

}
