package com.example.yucehan.trainer;

/**
 * Created by Yucehan on 09.04.2016.
 */
public class Workout {
    private int id;
    private String workoutDay;
    private int ptag;

    public Workout(String workoutDay) {
        this.workoutDay = workoutDay;
    }
    public int getId() {
        return id;
    }
    public String getWorkoutDay() {
        return workoutDay;
    }
    public int getTag() {return ptag;}
    public void setTag(int tag) {this.ptag = tag;}
}
