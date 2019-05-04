package com.example.user.fitness;

public class DietPlan {
    private String mName;
    private String mDescription;
    private int mImage;

    public DietPlan(String mName, String mDescription, int mImage) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
