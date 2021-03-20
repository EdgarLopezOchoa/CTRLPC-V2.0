package com.example.ctrlpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorCuenta extends RecyclerView.Adapter<AdaptadorCuenta.ViewHolderDatos> {

    private List<CuentaBD> listusuarios;


    public AdaptadorCuenta( List<CuentaBD> listusuarios) {
        this.listusuarios = listusuarios;

    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /*LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lista_articulos,null);*/

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuentausuario,null,false);
        return new ViewHolderDatos(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        CuentaBD cuenta = listusuarios.get(position);


        holder.nombres.setText("NOMBRE: " + cuenta.getNOMBRES() + " " + cuenta.getAPELLIDOS());
        holder.email.setText(cuenta.getEMAIL());

    }

    @Override
    public int getItemCount() {
        return listusuarios.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nombres,apellidos,email;
        ImageView usuario;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.TVemailA1);
            nombres = itemView.findViewById(R.id.TVnombresA1);

        }

    }
}