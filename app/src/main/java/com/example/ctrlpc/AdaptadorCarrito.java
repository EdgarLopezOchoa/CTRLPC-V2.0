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

public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.ViewHolderDatos> {

    private List<CarritoBD> Listcarrito;



    public AdaptadorCarrito( List<CarritoBD> Listcarrito) {
        this.Listcarrito = Listcarrito;


    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_carrito,null,false);
        return new ViewHolderDatos(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        CarritoBD carrito = Listcarrito.get(position);

        Picasso.get()
                .load(carrito.getFOTO())
                .into(holder.articulo);
        holder.titulo.setText(carrito.getNOMBRE());
        holder.descripcion.setText(carrito.getDESCRIPCION());
        holder.precio.setText(carrito.getPRECIO());



    }

    @Override
    public int getItemCount() {
        return Listcarrito.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView titulo,descripcion,precio;
        ImageView articulo;
        Button comprar;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            comprar = itemView.findViewById(R.id.BTNeliminarA2);
            titulo = itemView.findViewById(R.id.TVtituloA2);
            descripcion = itemView.findViewById(R.id.TVdescripcionA2);
            precio = itemView.findViewById(R.id.TVPA2);
            articulo = itemView.findViewById(R.id.IVA2);

        }

    }
}