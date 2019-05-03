package com.example.user.fitness;

public class Blog {
    private long mID;
    private String mTitle;
    private String mBody;
    private String mDate;

    public Blog(String mTitle, String mDate, String mBody) {
        this.mTitle = mTitle;
        this.mDate = mDate;
        this.mBody = mBody;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public long getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String mBody) {
        this.mBody = mBody;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }
}
