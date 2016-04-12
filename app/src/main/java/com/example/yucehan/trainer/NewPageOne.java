package com.example.yucehan.trainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class NewPageOne extends AppCompatActivity {

    TextView[] textView;

    public String day;
    String programName;

    TrainerDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page_one);

        // for getting the program name NewProgram activity
        Intent intent = getIntent();
        if(intent != null) {
            programName = intent.getStringExtra("name");
        }

        textView = new TextView[8];

        textView[1] = (TextView) findViewById(R.id.textView_Monday);
        textView[2] = (TextView) findViewById(R.id.textView_Tuesday);
        textView[3] = (TextView) findViewById(R.id.textView_Wednesday);
        textView[4] = (TextView) findViewById(R.id.textView_Thursday);
        textView[5] = (TextView) findViewById(R.id.textView_Friday);
        textView[6] = (TextView) findViewById(R.id.textView_Saturday);
        textView[7] = (TextView) findViewById(R.id.textView_Sunday);


        textView[2].setText(programName);

    }
    public void MonWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Monday","day");
        startActivity(intent);
    }
    public void TueWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Tuesday","day");
        startActivity(intent);
    }
    public void WedWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Wednesday", "day");
        startActivity(intent);
    }
    public void ThuWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Thursday", "day");
        startActivity(intent);
    }
    public void FriWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Friday", "day");
        startActivity(intent);
    }
    public void SatWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Saturday", "day");
        startActivity(intent);
    }
    public void SunWorkout(View view)
    {
        Intent intent = new Intent(this,NewPageTwo.class);
        intent.putExtra("Sunday", "day");
        startActivity(intent);
    }

}
