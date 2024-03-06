package com.example.arrterdefumer.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Puchos.db";
    public static final String TABLE_CIG = "cigarrillos";
    public static final String TABLE_PAQ = "paquetes";
    public String ROWS_CIG = TABLE_CIG + "(" +
            "id INTEGER PRIMARY KEY NOT NULL," +
            " fecha TEXT NOT NULL," +
            " hora TEXT NOT NULL," + ")";

    public String ROWS_PAQ = TABLE_PAQ + "(" +
            "id INTEGER PRIMARY KEY NOT NULL," +
            " fecha TEXT NOT NULL," +
            " hora TEXT NOT NULL," +
            " gasto INTEGER NOT NULL" + ")";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + ROWS_CIG);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + ROWS_PAQ);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CIG);
        db.execSQL("DROP TABLE " + TABLE_PAQ);
        onCreate(db);
    }
}
