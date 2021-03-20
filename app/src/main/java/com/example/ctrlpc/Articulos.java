package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Articulos extends AppCompatActivity {


    ArrayList<String> listdatos;

    RecyclerView recyclerView;

    List<ArticulosDB> Listdatos;

    String articulo = InicioFragment.Articulo;

    int accion = InicioFragment.Accion;

    RequestQueue requestQueue;




    /*public int NumeroDeArticulo = inicioFragment.Articulo;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.RVarticulos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Listdatos = new ArrayList<>();


        traerarticulos(accion);



    }


    private void CargarArticulosDeRam(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject articulos = array.getJSONObject(i);

                        Listdatos.add(new ArticulosDB(
                                articulos.getInt("ID_PROD"),
                                articulos.getInt("PRECIO"),
                                articulos.getString("NOMBRE"),
                                articulos.getString("DESCRIPCION"),
                                articulos.getString("FOTO")



                        ));

                    }


                    AdaptadorLista adaptadorLista = new AdaptadorLista(Articulos.this, Listdatos);
                    recyclerView.setAdapter(adaptadorLista);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();

                    }

                });

        Volley.newRequestQueue(this).add(stringRequest);

    }

    private void CargarArticulosDeDiscos(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject articulos = array.getJSONObject(i);

                        Listdatos.add(new ArticulosDB(
                                articulos.getInt("ID_PROD"),
                                articulos.getInt("PRECIO"),
                                articulos.getString("NOMBRE"),
                                articulos.getString("DESCRIPCION"),
                                articulos.getString("FOTO")



                        ));

                    }


                    AdaptadorLista adaptadorLista = new AdaptadorLista(Articulos.this, Listdatos);
                    recyclerView.setAdapter(adaptadorLista);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();

                    }

                });

        Volley.newRequestQueue(this).add(stringRequest);

    }

    public void traerarticulos(int numeroDeArticulo){
        switch (numeroDeArticulo){

            case 1:
                CargarArticulosDeRam("https://carlosarmenta.000webhostapp.com/ctrlpc/buscar_articulos.php?TIPO="+articulo);
                break;

            case 2:
                CargarArticulosDeDiscos("https://carlosarmenta.000webhostapp.com/ctrlpc/buscar_articulos.php?TIPO="+articulo);
                break;

        }


    }


}