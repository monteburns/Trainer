package com.example.yucehan.trainer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class NewPageTwo extends AppCompatActivity {

    TableLayout tableLExercises;
    EditText editTExer, editTSets, editTRest;
    Button add_btn;

    TrainerDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page_two);

        // for getting the workout day from NewPageOne activity
        Intent intent = getIntent();
        if(intent != null) {
            String wDay = intent.getStringExtra("day");
        }

        dbHelper = new TrainerDbHelper(getApplicationContext());

        tableLExercises = (TableLayout) findViewById(R.id.tableLayout_exercises);
        editTExer = (EditText) findViewById(R.id.editText_exer);
        editTRest = (EditText) findViewById(R.id.editText_rest);
        editTSets = (EditText) findViewById(R.id.editText_sets);
        add_btn = (Button) findViewById(R.id.button_addE);


//        dbHelper.addExercise(new Exercise(1, "Deneme", 3, 1));

//        BuildTable();


        add_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 String exerciseName = editTExer.getText().toString();
                 int sets = Integer.parseInt(editTSets.getText().toString());
                 double rest = Double.parseDouble(editTRest.getText().toString());

   //              dbHelper.addExercise(new Exercise(1, exerciseName, sets, rest));
 //                BuildTable();


            }
        });

    }

/*
    private void BuildTable() {
        //Cursor c = dbHelper.readExercise();

        int rows = c.getCount();
        int cols = c.getColumnCount();

        c.moveToFirst();

        // outer for loop
        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 0; j < cols; j++) {

                TextView tv = new TextView(this);
                tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                //   tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                row.addView(tv);

            }

            c.moveToNext();

            tableLExercises.addView(row);

        }
    }
*/

 /*   private class MyAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            tableLExercises.removeAllViews();

            ProgressDialog PD = new ProgressDialog(NewPageTwo.this);
            PD.setTitle("Please Wait..");
            PD.setMessage("Loading...");
            PD.setCancelable(false);
            PD.show();
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            BuildTable();
            PD.dismiss();
        }
    }*/
}

