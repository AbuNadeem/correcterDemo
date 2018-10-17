package com.ozonestudios.fontsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class mydatabase extends SQLiteOpenHelper {
    private static final String nameDB = "myDataBase.db";

    public mydatabase(Context context) {
        super(context, nameDB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mytable(id INTEGER PRIMARY KEY AUTOINCREMENT ,name Text,age Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS mytable");
        onCreate(db);
    }


    public boolean insertData(String name, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        long resault = db.insert("mytable", null, cv);
        if (resault == -1)
            return false;
        else
            return true;

    }


    public ArrayList getAllrecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        String t1,t2,t3;
        myFonts font;
        ArrayList arrayList=new ArrayList();
        Cursor cr = db.rawQuery("select * from mytable", null);
        cr.moveToFirst();
        while (cr.isAfterLast() == false) {
            t1 = cr.getString(0);
            t2 = cr.getString(1);
            t3 = cr.getString(2);

            font = new myFonts(t1,t2,t3);
            arrayList.add(font);
            cr.moveToNext();
        }
        return arrayList;
        }


    public void updateData(String id, String name, String age) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("age",age);

        db.update("mytable", cv, "id= ?",new String[]{id});
        }


    public Integer Delete(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("mytable","id=?",new String[]{id});

    }
}
