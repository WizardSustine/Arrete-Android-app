package com.example.arrterdefumer.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import androidx.annotation.Nullable;

import com.example.arrterdefumer.DB.DbHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CurrentDateTime {
    private Calendar fecha;
    private String dia, hora;
    private LocalDateTime horario;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public CurrentDateTime() {
        this.fecha = Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH) + 1; // Los meses comienzan desde 0, por lo que se suma 1
        int day = fecha.get(Calendar.DAY_OF_MONTH);
        this.dia = Integer.toString(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        this.horario = LocalDateTime.now();

        // Format LocalDateTime to String
        this.hora = horario.format(dateTimeFormatter);
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    /*public boolean editarFecha (String fecha, int cigarrillos, int paquetes, int gasto){
        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try{
            db.execSQL("UPDATE " + TABLE_AGENDA + " SET cigarrillos = '" + cigarrillos + "', paquetes = '" + paquetes + "', gasto = '" + gasto + "' WHERE fecha = '" + fecha + "'");
            correcto = true;
        }catch (Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }

        return correcto;
    }

    public Fecha verFecha(String f){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Fecha fecha;
        Cursor cursorFecha;

        try {
            cursorFecha = db.rawQuery("SELECT * FROM " + TABLE_AGENDA + " WHERE fecha = " + f + " LIMIT 1", null);

            if (cursorFecha.moveToFirst()) {
                fecha = new Fecha();
                fecha.setFecha(cursorFecha.getString(0));
                fecha.setCigarrillos(cursorFecha.getInt(1));
                fecha.setPaquetes(cursorFecha.getInt(2));
                fecha.setGasto(cursorFecha.getInt(3));
            }else{
                fecha = null;
            }
            cursorFecha.close();
            if(fecha != null) {
                return fecha;
            }else {
                return null;
            }
        }catch (Exception ex){
            ex.toString();
        }
        return null;
    }

    public void insertarCig(Fecha fecha) {

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("fecha", fecha.getFecha());
            values.put("cigarrillos", fecha.getCigarrillos());
            values.put("paquetes", fecha.getPaquetes());
            values.put("gasto", fecha.getGasto());

            db.insert(TABLE_AGENDA, null, values);
        } catch (Exception ex){
            Toast.makeText(context , ex.toString(), Toast.LENGTH_LONG).show();
        }

    }
*/
}
