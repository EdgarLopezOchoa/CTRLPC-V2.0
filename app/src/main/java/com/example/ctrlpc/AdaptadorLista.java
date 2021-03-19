package com.example.ctrlpc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolderDatos> {

    private List<ArticulosDB> listdatos;
    private Context mCtx;

    public AdaptadorLista(Context mCtx, List<ArticulosDB> listdatos) {
        this.listdatos = listdatos;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.lista_articulos,null);
        return new ViewHolderDatos(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        ArticulosDB articulos = listdatos.get(position);

        Glide.with(mCtx)
                .load(articulos.getFOTO())
                .into(holder.articulo);
        holder.titulo.setText(articulos.getNOMBRE());
        holder.descripcion.setText(articulos.getDESCRIPCION());
        holder.precio.setText("$" + articulos.getPRECIO());

    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo,descripcion,precio;
        ImageView articulo;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.TVtituloA1);
            descripcion = itemView.findViewById(R.id.TVdescripcionA1);
            precio = itemView.findViewById(R.id.TVPA1);
            articulo = itemView.findViewById(R.id.IVA1);

        }

    }
}