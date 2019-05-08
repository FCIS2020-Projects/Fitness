package com.example.user.fitness;

public class Meal {
    private String mName;
    private int mCalories;
    private String mDate;

    public Meal(String mName, int mCalories, String mDate) {
        this.mName = mName;
        this.mCalories = mCalories;
        this.mDate = mDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmCalories() {
        return mCalories;
    }

    public void setmCalories(int mCalories) {
        this.mCalories = mCalories;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
