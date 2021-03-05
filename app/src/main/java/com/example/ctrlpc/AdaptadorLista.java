package com.example.ctrlpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolderDatos> {

    private List<Articulos> listdatos;
    private Context mCtx;

    public AdaptadorLista(Context mCtx, List<Articulos> listdatos) {
        this.listdatos = listdatos;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_articulos,null,false);
        return null;



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        Articulos articulos = listdatos.get(position);

        Glide.with(mCtx)
                .load(articulos.getImagen())
                .into(holder.articulo);

    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo,descripcion;
        ImageView articulo;
        Button Favorito,Comprar,Lista;
        CardView cardView;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.TVtituloA1);
            descripcion = itemView.findViewById(R.id.TVdescripcionA1);
            articulo = itemView.findViewById(R.id.IVA1);
            Favorito = itemView.findViewById(R.id.BTNfavortioA1);
            Comprar = itemView.findViewById(R.id.BTNcomprarA1);
            Lista = itemView.findViewById(R.id.BTNlistaA1);
            cardView = itemView.findViewById(R.id.CVarticulo1);
        }

        public void asignarDatos(String dato) {
            titulo.setText(dato);
        }
    }
}
