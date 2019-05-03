package com.example.user.fitness.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.fitness.Blog;
import com.example.user.fitness.Database.Contract.BlogEntry;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public final static String LOG_TAG = DbHelper.class.getSimpleName();
    public final static String DATABASE_NAME = "fitness.db";
    public final static int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_BLOGS_TABLE = "CREATE TABLE " + BlogEntry.TABLE_NAME + " ("
                + BlogEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BlogEntry.COLUMN_TITLE + " TEXT NOT NULL, "
                + BlogEntry.COLUMN_DATE + " DATE NOT NULL, "
                + BlogEntry.COLUMN_BODY + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_BLOGS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Blog> getBlogs()
    {
        ArrayList<Blog> blogs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(BlogEntry.TABLE_NAME, null,null,null,null,null, null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                String title = cursor.getString(cursor.getColumnIndex(BlogEntry.COLUMN_TITLE));
                String date = cursor.getString(cursor.getColumnIndex(BlogEntry.COLUMN_DATE));
                String body = cursor.getString(cursor.getColumnIndex(BlogEntry.COLUMN_BODY));

                Blog blog = new Blog(title, date, body);

                blogs.add(blog);

                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return blogs;
    }

    public long AddBlog(Blog blog)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues blogContent = new ContentValues();
        blogContent.put(BlogEntry.COLUMN_TITLE, blog.getTitle());
        blogContent.put(BlogEntry.COLUMN_DATE, blog.getDate());
        blogContent.put(BlogEntry.COLUMN_BODY, blog.getBody());

        long id = db.insert(BlogEntry.TABLE_NAME, null, blogContent);
        db.close();
        return id;
    }

    public void DeleteBlog(Blog blog)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(BlogEntry.TABLE_NAME, BlogEntry.COLUMN_ID + "=?", new String[]{String.valueOf(blog.getID())});
        db.close();
    }
}