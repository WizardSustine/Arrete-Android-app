package com.example.arrterdefumer.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.arrterdefumer.DB.DbHelper;
import com.example.arrterdefumer.controller.CurrentDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import androidx.annotation.Nullable;
import java.time.LocalDateTime;

public class SmokingEvent extends DbHelper {
    private CurrentDateTime current;

    Context context;
    public SmokingEvent(@Nullable Context context){
        super(context);
        this.context = context;
    }
    public void insertSmoke(){
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            current = new CurrentDateTime();

            ContentValues values = new ContentValues();

            values.put("fecha", current.getDia());
            values.put("hora", current.getHora());

            db.insert(TABLE_CIG, null, values);
        }catch (Exception ex){
            Toast.makeText(context , ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public int getSmoke_dia(String d){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursorDia;

        int cantidad = 0;

        try {
            cursorDia = db.rawQuery("SELECT COUNT (*) FROM " + TABLE_CIG + " WHERE fecha = " + d, null);

            while(cursorDia!=null && cursorDia.getCount()!=0){
                cantidad++;
                cursorDia.moveToNext();
            }
            cursorDia.close();
            return cantidad;
        }catch (Exception ex){
            ex.toString();
        }
        return cantidad;
    }
    public ArrayList<String> getTimes_Smoke_dia(String d){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursorDia;

        ArrayList<String> cantidad = new ArrayList();

        try {
            cursorDia = db.rawQuery("SELECT COUNT (*) FROM " + TABLE_CIG + " WHERE fecha = " + d, null);

            while(cursorDia!=null && cursorDia.getCount()!=0){
                cantidad.add(cursorDia.getString(2));
                cursorDia.moveToNext();
            }
            cursorDia.close();
            return cantidad;
        }catch (Exception ex){
            ex.toString();
        }
        return cantidad;
    }
}
