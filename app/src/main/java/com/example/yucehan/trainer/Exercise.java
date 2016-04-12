package com.example.yucehan.trainer;

/**
 * Created by Yucehan on 09.04.2016.
 */
public class Exercise {
    private int id;
    private String exerciseName;
    private int numberOfSets;
    private double rest;
    private double weight;
    private int reps;
    private int wtag;

    public Exercise(String exerciseName, int numberOfSets, double rest) {
        this.exerciseName = exerciseName;
        this.numberOfSets = numberOfSets;
        this.rest = rest;
    }
    public String getExerciseName() {
        return exerciseName;
    }
    public  int getNumberOfSets() {
        return numberOfSets;
    }
    public double getRest() {
        return rest;
    }
    public double getWeight() {
        return weight;
    }
    public int getReps() {
        return reps;
    }
    public int getTag() {return wtag;}
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setReps (int reps) {
        this.reps = reps;
    }
    public void setTag (int tag) { this.wtag = tag; }


}
