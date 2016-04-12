package com.example.yucehan.trainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //on click NEW button; opens the activity for creating new training program
    public void newProgram(View view)
    {
        Intent intent = new Intent(this,NewProgramActivity.class);
        startActivity(intent);
    }
    //on click LIST button; opens the activity for creating listing training programs
    public void listPrograms(View view)
    {
        Intent intent = new Intent(this,ListProgramsActivity.class);
        startActivity(intent);
    }
}
