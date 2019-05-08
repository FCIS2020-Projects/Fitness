package com.example.user.fitness;

public class User {
    private String mEmail;
    private String mPassword;
    private int mDailyCalories;


    public User(String email, String password, int dailyCalories) {
        mEmail = email;
        mPassword = password;
        mDailyCalories = dailyCalories;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getmDailyCalories() {
        return mDailyCalories;
    }

    public void setmDailyCalories(int mDailyCalories) {
        this.mDailyCalories = mDailyCalories;
    }
}
