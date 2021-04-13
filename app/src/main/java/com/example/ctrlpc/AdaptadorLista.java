package com.example.ctrlpc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolderDatos> {

    private List<ArticulosDB> listdatos;

    public static String titulo,descripcion, precio,imagen,id;
    public static int permiso = 0;


    public AdaptadorLista( List<ArticulosDB> listdatos) {
        this.listdatos = listdatos;


    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_articulos,null,false);
        return new ViewHolderDatos(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        ArticulosDB articulos = listdatos.get(position);

        Picasso.get()
                .load(articulos.getFOTO())
                .into(holder.articulo);
        holder.titulo.setText(articulos.getNOMBRE());
        holder.descripcion.setText(articulos.getDESCRIPCION());
        holder.precio.setText("$" + articulos.getPRECIO());



        holder.comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permiso = 1;

                titulo = holder.titulo.getText().toString();
                descripcion = holder.descripcion.getText().toString();
                precio = holder.precio.getText().toString();
                imagen = articulos.getFOTO();
                id = "" + articulos.getID_PROD();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo,descripcion,precio;
        ImageView articulo;
        Button comprar;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            comprar = itemView.findViewById(R.id.BTNcomprarA1);
            titulo = itemView.findViewById(R.id.TVtituloA1);
            descripcion = itemView.findViewById(R.id.TVdescripcionA1);
            precio = itemView.findViewById(R.id.TVPA1);
            articulo = itemView.findViewById(R.id.IVA1);

        }

    }
}