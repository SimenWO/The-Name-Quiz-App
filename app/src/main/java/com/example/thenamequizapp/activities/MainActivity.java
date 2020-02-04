package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import com.example.thenamequizapp.Questions;
import com.example.thenamequizapp.R;
import com.example.thenamequizapp.SQLiteHelper;


public class MainActivity extends AppCompatActivity {

    public static SQLiteHelper sqLiteHelper;
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

        sqLiteHelper = new SQLiteHelper(this, "PeopleDB.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PEOPLE(id VARCHAR PRIMARY KEY, image BLOB, name VARCHAR)");


        // get all data from sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM PEOPLE");

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
        // final int count = ((Questions) this.getApplication()).getCount();

        /**
         * If the count is 0 then all of the names and images will be added to the global lists.
         */
        //if (count == 0) {
        //    addQuestions();
        //}

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
