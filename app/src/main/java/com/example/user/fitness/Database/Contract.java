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

}