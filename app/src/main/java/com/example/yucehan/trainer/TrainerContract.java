package com.example.yucehan.trainer;

import android.provider.BaseColumns;

/**
 * Created by Yucehan on 05.04.2016.
 */
public final class TrainerContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TrainerContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Entry implements BaseColumns {

        public static final String TABLE_PROGRAM = "Programs";
        public static final String PROGRAM_ID =  "_id";
        public static final String PROGRAM_NAME = "Program";

        public static final String TABLE_WORKOUT = "Workouts";
        public static final String WORKOUT_ID = "_id";
        public static final String WORKOUT_DAY = "Day";
        //for pointing which program this workout belongs
        public static final String PTAG = "Tag";

        public static final String TABLE_EXERCISE = "Exercises";
        public static final String EXERCISE_ID = "_id";
        public static final String EXERCISE = "Exercise";
        public static final String SETS_NUMBER = "Sets";
        public static final String REST = "Rest";
        public static final String WEIGHT = "Kilograms";
        public static final String REP = "Reps";
        //for pointing which workout this exercise belongs
        public static final String WTAG = "Tag";

        public static final String CREATE_TABLE_PROGRAM = "CREATE TABLE " + TABLE_PROGRAM + "("
                + PROGRAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PROGRAM_NAME + " TEXT" + " )";

        public static final String CREATE_TABLE_WORKOUT= "CREATE TABLE " + TABLE_WORKOUT + "("
                + WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + WORKOUT_DAY + " TEXT" +
                PTAG + "INTEGER" + " )";

        public static final String CREATE_TABLE_EXERCISE="CREATE TABLE " + TABLE_EXERCISE + "("
                + EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EXERCISE + " TEXT, " + SETS_NUMBER
                + " INTEGER DEFAULT 0, " + REST + " REAL, " + WEIGHT + " REAL, "+ REP + " INTEGER, " +
                WTAG + "INTEGER" +" )";


    }
}
