package com.example.feedbackdharsh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.ContextMenu;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Date;

public class FeedbackDBhelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Foodator.db";
    public static final String TABLE_NAME_FB="feedback_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="RATE";
    public static final String COL_4="FEEDBACK";


    public FeedbackDBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME_FB + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, RATE NUMBER, FEEDBACK TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_FB);
        onCreate(db);
    }

    public boolean insertFeedback(String name, String rate, String feedbacks){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, rate);
        contentValues.put(COL_4, feedbacks);
        long result=db.insert(TABLE_NAME_FB, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor ViewData(){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from "+ TABLE_NAME_FB, null);
        return cursor;
    }

    public Cursor getViewData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String query="select max(ID) from " + TABLE_NAME_FB;
        Cursor cursor= db.rawQuery(query, null);

        return cursor;
    }

    public boolean updateData(String id, String name, String rate, String feedback){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,rate);
        contentValues.put(COL_4,feedback);
        db.update(TABLE_NAME_FB, contentValues, "ID = ?",new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_FB, "ID = ?", new String[] {id});
    }

    public Cursor ViewMyData(String id){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from "+ TABLE_NAME_FB + " where ID = " + id + "", null );
        return cursor;
    }

    public Cursor calaverageRate(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor rate=sqLiteDatabase.rawQuery("SELECT avg(RATE) FROM "+ TABLE_NAME_FB, null);
        return rate;
    }
}

//,hbkjhvl