package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import com.example.thenamequizapp.R;

public class SettingsActivity extends AppCompatActivity {

    EditText nameInput;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameInput = findViewById(R.id.nameInputSettings);
        saveButton = findViewById(R.id.saveButtonSettings);

        /**
         * Fetches the name shared preferences
         */
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = pref.getString("name", "");

        nameInput.setText(name);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameInput.getText().toString().equals("")) {
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("name", nameInput.getText().toString());
                    myEdit.commit();
                    finish();
                }
            }
        });
    }
}
