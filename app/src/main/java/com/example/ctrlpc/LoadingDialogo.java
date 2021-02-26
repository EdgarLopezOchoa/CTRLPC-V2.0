package com.example.ctrlpc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.view.LayoutInflater;

public class LoadingDialogo {
   Fragment activity;
    AlertDialog dialog;
    LoadingDialogo(Fragment myActivity){
        activity = myActivity;
    }


    /*void LoadingAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo_de_carga, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void dismissdialogo(){
        dialog.dismiss();
    }*/

}
