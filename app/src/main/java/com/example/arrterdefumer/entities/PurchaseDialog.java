package com.example.arrterdefumer.entities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.arrterdefumer.MainActivity;
import com.example.arrterdefumer.R;

public class PurchaseDialog {
    TextView money_txt;
    ImageButton add_btn, decrease_btn;
    Button ok_btn;
    private int price;

    View dialog;

    public PurchaseDialog(Context context){
        dialog = LayoutInflater.from(context).inflate(R.layout.purchase_dialog, null);
        Activity act = new Activity();
        act.startActivity(new Intent());
        act.setContentView(dialog);

        money_txt = (TextView) act.findViewById(R.id.money_txt);
        add_btn = (ImageButton) act.findViewById(R.id.add_btn);
        decrease_btn = (ImageButton) act.findViewById(R.id.decrease_btn);
        ok_btn = (Button) act.findViewById(R.id.ingresar_money);

        this.price = 2000;
        money_txt.setText(String.valueOf(price));

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price += 50;
                money_txt.setText(String.valueOf(price));
            }
        });

        decrease_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price -= 50;
                money_txt.setText(String.valueOf(price));
            }
        });

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackPurchase p = new PackPurchase(context);
                p.insertPack(price);
                act.finish();
            }
        });
    }
}
