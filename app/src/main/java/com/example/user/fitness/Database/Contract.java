package com.example.user.fitness.Database;

import android.provider.BaseColumns;

public class Contract {
    public static class BlogEntry implements BaseColumns{
        public static String TABLE_NAME = "Blogs";
        public static String COLUMN_ID = "ID";
        public static String COLUMN_TITLE = "Title";
        public static String COLUMN_DATE = "Date";
        public static String COLUMN_BODY = "Body";
    }

    public  static class UserEntry implements BaseColumns{
        public static String TABLE_NAME = "Users";
        public static String COLUMN_EMAIL = "Email";
        public static String COLUMN_PASSWORD = "Password";
        public static String COLUMN_CALORIES = "Calories";
    }

    public  static class MealEntry implements BaseColumns{
        public static String TABLE_NAME = "Meals";
        public static String COLUMN_NAME = "Name";
        public static String COLUMN_CALORIES = "Calories";
        public static String COLUMN_DATE = "Date";
        public static String COLUMN_USER = "UserEmail";
    }
}