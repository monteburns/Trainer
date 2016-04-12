package com.example.yucehan.trainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yucehan on 05.04.2016.
 */

public class TrainerDbHelper extends SQLiteOpenHelper {

    static final String DB_NAME="Programs.db";
    static final int DB_VERSION = 11;


    public TrainerDbHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TrainerContract.Entry.CREATE_TABLE_PROGRAM);
        db.execSQL(TrainerContract.Entry.CREATE_TABLE_WORKOUT);
        db.execSQL(TrainerContract.Entry.CREATE_TABLE_EXERCISE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TrainerContract.Entry.TABLE_PROGRAM);
        db.execSQL("DROP TABLE IF EXISTS " + TrainerContract.Entry.TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS " + TrainerContract.Entry.TABLE_EXERCISE);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addProgram (Program program) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues pValues = new ContentValues();
        pValues.put(TrainerContract.Entry.PROGRAM_NAME,program.getProgramName());
        db.insert(TrainerContract.Entry.TABLE_PROGRAM, null, pValues);
        db.close();
    }

    public void addWorkout (Workout workout) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues wValues = new ContentValues();
        wValues.put(TrainerContract.Entry.WORKOUT_DAY,workout.getWorkoutDay());
        wValues.put(TrainerContract.Entry.PTAG,workout.getTag());
        db.insert(TrainerContract.Entry.TABLE_WORKOUT, null, wValues);
    }

    public void addExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues eValues = new ContentValues();
        eValues.put(TrainerContract.Entry.EXERCISE,exercise.getExerciseName());
        eValues.put(TrainerContract.Entry.SETS_NUMBER, exercise.getNumberOfSets());
        eValues.put(TrainerContract.Entry.REST, exercise.getRest());
        eValues.put(TrainerContract.Entry.WTAG, exercise.getTag());
        db.insert(TrainerContract.Entry.TABLE_EXERCISE, null, eValues);
        db.close();
    }
    public void UpdateExercise (double weight, int reps) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues eValues = new ContentValues();
        eValues.put(TrainerContract.Entry.WEIGHT, weight);
        eValues.put(TrainerContract.Entry.REP, reps);
        //not sure if it will work
        db.update(TrainerContract.Entry.TABLE_EXERCISE, eValues, "ID =" + TrainerContract.Entry.EXERCISE_ID, null);
        db.close();
    }
    public List<Program> listPrograms() {
        List<Program> programs = new ArrayList<Program>();
        SQLiteDatabase db = this.getWritableDatabase();

        String[] allColumns = new String[] { TrainerContract.Entry.PROGRAM_ID, TrainerContract.Entry.PROGRAM_NAME};
        Cursor c = db.query(TrainerContract.Entry.TABLE_PROGRAM, allColumns, null, null, null, null, null);

        while (c.moveToNext()) {
            Program program = new Program(c.getString(1));
            programs.add(program);
        }
        return programs;
    }

    public Exercise getExercises(int tag) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] allColumns = new String[] { TrainerContract.Entry.EXERCISE_ID, TrainerContract.Entry.EXERCISE,
                TrainerContract.Entry.SETS_NUMBER, TrainerContract.Entry.WEIGHT, TrainerContract.Entry.REP,
                TrainerContract.Entry.WTAG};

        String[] column = new String[] { String.valueOf(tag) };

        Cursor c = db.query(TrainerContract.Entry.TABLE_EXERCISE, allColumns, "tag = ? ", column, null,
                null, null,null);

        if (c != null) {
            c.moveToFirst();
        }
        //creating an exercise to return for wanted exercise in database (with sets and reps)
        Exercise exercise = new Exercise(c.getString(1),Integer.parseInt(c.getString(2)),Double.parseDouble(c.getString(4)));

        db.close();
        return exercise;
    }
    public Workout getWorkouts(int tag) {
        SQLiteDatabase db = this.getWritableDatabase();

        String[] allColumns = new String[] { TrainerContract.Entry.WORKOUT_ID, TrainerContract.Entry.WORKOUT_DAY,
                TrainerContract.Entry.PTAG};

        String[] column = new String[] { String.valueOf(tag) };

        Cursor c = db.query(TrainerContract.Entry.TABLE_WORKOUT, allColumns, "tag = ?", column, null,
                null, null, null);

        if (c != null) {
            c.moveToFirst();
        }
        //creating an workout to return for wanted workout in database
        Workout workout = new Workout(c.getString(1));
        db.close();
        return workout;
    }


}
