package com.droidtech.ridetorise.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.droidtech.ridetorise.R;

public class CustomAlert  {
    Context context;
    AlertDialog alertDialog;

    public CustomAlert(Context context) {
        this.context = context;
    }

    public void show(String str , String heading) {
        try {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(context, R.style.customLoader);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_alert_layout, null);
        Button ok = view.findViewById(R.id.ok);
        TextView msg = view.findViewById(R.id.msg);
        TextView header  =view.findViewById(R.id.header) ;
        header.setText(heading);
        msg.setText(str);
        alert.setView(view);
        alert.setCancelable(false);
        alertDialog = alert.create();

        alertDialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }

    public void dismiss() {
        alertDialog.dismiss();
    }
}
