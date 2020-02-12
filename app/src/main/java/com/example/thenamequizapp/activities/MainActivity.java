package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;

import com.example.thenamequizapp.SQLiteHelper;
import com.example.thenamequizapp.Questions;

import android.graphics.drawable.Drawable;
import android.content.SharedPreferences;

import android.graphics.BitmapFactory;

import com.example.thenamequizapp.R;

import android.widget.ImageButton;

import android.database.Cursor;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    public static SQLiteHelper sqLiteHelper;
    ImageButton startButton;
    Button manageButton;
    Button settingsButton;

    /**
     * When NewPersonActivity is finished() the activity will be recreated.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startButton = findViewById(R.id.start);
        manageButton = findViewById(R.id.manage);
        settingsButton = findViewById(R.id.settingsButton);


        /**
         * Fetches the name shared preferences
         */
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = pref.getString("name", "");

        /**
         * Creates SQLite database and creates the database if it is not created
         */
        sqLiteHelper = new SQLiteHelper(this, "PeopleDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PEOPLE(id VARCHAR PRIMARY KEY, image BLOB, name VARCHAR)");


        /**
         * Get all the data from SQLite and puts them in a cursor
         */
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM PEOPLE");

        /**
         * Adds testpersons for testing getResources().getDrawable(R.drawable.myImage);
         */

        if(cursor.getCount() == 0 ) {
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.anders), "Anders");
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.simen), "simen");
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.sebastian), "sebastian");
        } else if(cursor.getCount() == 1){
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.anders), "Anders");
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.simen), "simen");
        } else if(cursor.getCount() == 2){
            sqLiteHelper.insertData(UUID.randomUUID().toString(), getResources().getDrawable(R.drawable.simen), "simen");
        }

        ((Questions) this.getApplication()).clear();
        /**
         * Fetches the saved questions using SQLite
         */
        while (cursor.moveToNext()) {
            String sqlId = cursor.getString(0);
            byte[] sqlImage = cursor.getBlob(1);
            String sqlName = cursor.getString(2);

            Drawable DrawableImage = new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(sqlImage, 0, sqlImage.length));

            ((Questions) this.getApplication()).addPerson(sqlId, DrawableImage, sqlName);
        }

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
         *  Starts new activity.
         */
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    Toast.makeText(getApplicationContext(), "No questions in the database!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    startActivity(intent);
                }
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

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
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
