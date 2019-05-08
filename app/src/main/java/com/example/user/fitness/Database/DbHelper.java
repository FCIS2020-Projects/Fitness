package com.example.user.fitness.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.fitness.Blog;
import com.example.user.fitness.Database.Contract.BlogEntry;
import com.example.user.fitness.Database.Contract.UserEntry;
import com.example.user.fitness.Database.Contract.MealEntry;
import com.example.user.fitness.Meal;
import com.example.user.fitness.User;

import java.util.ArrayList;
import java.util.Date;

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

        String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_EMAIL + " TEXT PRIMARY KEY, "
                + UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "
                + UserEntry.COLUMN_CALORIES + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_USERS_TABLE);

        String SQL_CREATE_MEALS_TABLE = "CREATE TABLE " + MealEntry.TABLE_NAME + " ("
                + MealEntry.COLUMN_NAME + " TEXT PRIMARY KEY, "
                + MealEntry.COLUMN_CALORIES + " INTEGER NOT NULL, "
                + MealEntry.COLUMN_DATE + " DATE NOT NULL, "
                + MealEntry.COLUMN_USER + " TEXT NOT NULL, " +
                "CONSTRAINT fk_user " +
                "FOREIGN KEY (" + MealEntry.COLUMN_USER + ") " +
                "REFERENCES " + UserEntry.TABLE_NAME + "(" + UserEntry.COLUMN_EMAIL + ")" +
                ");";

        db.execSQL(SQL_CREATE_MEALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DROP_BLOGS_TABLE = "DROP TABLE " + BlogEntry.TABLE_NAME;
        db.execSQL(SQL_DROP_BLOGS_TABLE);

        String SQL_DROP_USERS_TABLE = "DROP TABLE " + UserEntry.TABLE_NAME;
        db.execSQL(SQL_DROP_USERS_TABLE);

        String SQL_DROP_MEALS_TABLE = "DROP TABLE " + MealEntry.TABLE_NAME;
        db.execSQL(SQL_DROP_MEALS_TABLE);

        onCreate(db);
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

    public ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(UserEntry.TABLE_NAME, null,null,null,null,null, null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                String email = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_PASSWORD));
                int calories = cursor.getInt(cursor.getColumnIndex(UserEntry.COLUMN_CALORIES));

                User user = new User(email, password, calories);

                users.add(user);

                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return users;
    }
    public User getUser(String userEmail) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = UserEntry.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {userEmail};
        Cursor cursor = db.query(UserEntry.TABLE_NAME, null, selection, selectionArgs,null,null, null);

        User user = null;
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                String email = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_EMAIL));
                String password = cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_PASSWORD));
                int calories = cursor.getInt(cursor.getColumnIndex(UserEntry.COLUMN_CALORIES));

                user = new User(email, password, calories);

                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return user;
    }

    public long AddUser(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues userContent = new ContentValues();
        userContent.put(UserEntry.COLUMN_EMAIL, user.getmEmail());
        userContent.put(UserEntry.COLUMN_PASSWORD, user.getmPassword());
        userContent.put(UserEntry.COLUMN_CALORIES, user.getmDailyCalories());

        long id = db.insert(UserEntry.TABLE_NAME, null, userContent);
        db.close();
        return id;
    }

    public ArrayList<Meal> getMeals(String userEmail)
    {
        ArrayList<Meal> meals = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String selection = MealEntry.COLUMN_USER + " = ?";
        String[] selectionArgs = {userEmail};
        Cursor cursor = db.query(MealEntry.TABLE_NAME, null, selection, selectionArgs,null,null, null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                String name = cursor.getString(cursor.getColumnIndex(MealEntry.COLUMN_NAME));
                int calories = cursor.getInt(cursor.getColumnIndex(MealEntry.COLUMN_CALORIES));
                String date = cursor.getString(cursor.getColumnIndex(MealEntry.COLUMN_DATE));

                Meal meal = new Meal(name, calories, date);

                meals.add(meal);

                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return meals;
    }

    public long AddMeal(Meal meal, String userEmail)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues mealContent = new ContentValues();
        mealContent.put(MealEntry.COLUMN_NAME, meal.getmName());
        mealContent.put(MealEntry.COLUMN_CALORIES, meal.getmCalories());
        mealContent.put(MealEntry.COLUMN_DATE, meal.getmDate());
        mealContent.put(MealEntry.COLUMN_USER, userEmail);

        long id = db.insert(MealEntry.TABLE_NAME, null, mealContent);
        db.close();
        return id;
    }

    public ArrayList<Meal> getMeals(String userEmail, String dateNow) {
        ArrayList<Meal> meals = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String selection = MealEntry.COLUMN_USER + " = ? and " + MealEntry.COLUMN_DATE + " = ?";
        String[] selectionArgs = {userEmail, dateNow};
        Cursor cursor = db.query(MealEntry.TABLE_NAME, null, selection, selectionArgs,null,null, null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                String name = cursor.getString(cursor.getColumnIndex(MealEntry.COLUMN_NAME));
                int calories = cursor.getInt(cursor.getColumnIndex(MealEntry.COLUMN_CALORIES));
                String date = cursor.getString(cursor.getColumnIndex(MealEntry.COLUMN_DATE));

                Meal meal = new Meal(name, calories, date);

                meals.add(meal);


                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return meals;
    }

}
