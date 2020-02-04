package com.example.thenamequizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thenamequizapp.R;

public class NameActivity extends AppCompatActivity {

    EditText nameInput;
    Button saveButton;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameInput = findViewById(R.id.nameInputSharedPreferences);
        saveButton = findViewById(R.id.saveNameSharedPreferences);


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
