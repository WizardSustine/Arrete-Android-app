package com.example.arrterdefumer.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.arrterdefumer.DB.DbHelper;
import com.example.arrterdefumer.controller.CurrentDateTime;

public class PackPurchase extends DbHelper {
    private CurrentDateTime current;
    Context context;
    public PackPurchase(@Nullable Context context){
        super(context);
        this.context = context;
    }

    public void insertPack(int gasto){
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            current = new CurrentDateTime();

            ContentValues values = new ContentValues();

            values.put("fecha", current.getDia());
            values.put("hora", current.getHora());
            values.put("gasto", gasto);

            db.insert(TABLE_PAQ, null, values);


        }catch (Exception ex){
            Toast.makeText(context , ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public int getPack_dia(String d){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursorDia;

        int cantidad = 0;

        try {
            cursorDia = db.rawQuery("SELECT COUNT (*) FROM " + TABLE_PAQ + " WHERE fecha = " + d, null);

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
    public int getMoney_Pack_dia(String d){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursorDia;

        int money_spend = 0;

        try {
            cursorDia = db.rawQuery("SELECT COUNT (*) FROM " + TABLE_PAQ + " WHERE fecha = " + d, null);

            while(cursorDia!=null && cursorDia.getCount()!=0){
                money_spend += cursorDia.getInt(3);
                cursorDia.moveToNext();
            }
            cursorDia.close();
            return money_spend;
        }catch (Exception ex){
            ex.toString();
        }
        return money_spend;
    }
}
