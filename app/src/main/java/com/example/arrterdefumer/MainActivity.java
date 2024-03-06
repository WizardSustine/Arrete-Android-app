package com.example.arrterdefumer;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arrterdefumer.controller.CurrentDateTime;
import com.example.arrterdefumer.DB.DbHelper;
import com.example.arrterdefumer.entities.PurchaseDialog;
import com.example.arrterdefumer.entities.SmokingEvent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    TextView c_cig, c_paq, date_V;
    FloatingActionButton add_cig, add_paq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        c_cig = findViewById(R.id.c_cig);
        c_paq = findViewById(R.id.c_paq);
        date_V = findViewById(R.id.date_V);

        add_cig = findViewById(R.id.add_cig);
        add_paq = findViewById(R.id.add_paq);
        if(db != null){
            Toast.makeText(MainActivity.this, "Base creada con exito", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Base no creada", Toast.LENGTH_LONG).show();
        }
        CurrentDateTime c = new CurrentDateTime();
        date_V.setText(c.getDia());

        add_cig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmokingEvent smoke = new SmokingEvent(MainActivity.this);
            }
        });

        add_paq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PurchaseDialog buy = new PurchaseDialog(MainActivity.this);
            }
        });


    }
}