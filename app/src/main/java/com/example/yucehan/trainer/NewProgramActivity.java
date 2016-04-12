package com.example.yucehan.trainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class NewProgramActivity extends AppCompatActivity {

    EditText editText;
    String programName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_program);

        editText = (EditText) findViewById(R.id.editTextPname);

    }

    public void next(View view) {
        Intent intent = new Intent(this, NewPageOne.class);
        programName = editText.getText().toString();
        intent.putExtra("name",programName);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // think about it
        finish();
    }
}


