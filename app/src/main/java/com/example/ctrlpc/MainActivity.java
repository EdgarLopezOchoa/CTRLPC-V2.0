package com.example.ctrlpc;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button botonregistro;
    Dialog dialog;
    ArrayList<String> listdatos;

    RecyclerView recyclerView;

    List<Articulos> Listdatos;

    private String URL_Articulos = "https://carlosarmenta.000webhostapp.com/ctrlpc/buscar_articulos.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_Articulos, R.id.navigation_Carrito, R.id.navigation_Cuenta, R.id.navigation_configuracion)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

       /*recyclerView = findViewById(R.id.RVarticulos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listdatos = new ArrayList<String>();

        for (int i=0; i<=50;i++){

            listdatos.add("Titulo #" + i + "");
        }
        AdaptadorLista adaptadorLista = new AdaptadorLista(listdatos);
        recyclerView.setAdapter(adaptadorLista);*/


        recyclerView = findViewById(R.id.RVarticulos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Listdatos = new ArrayList<>();


        CargarArticulos();





    }


    private void CargarArticulos(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_Articulos, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject articulos = array.getJSONObject(i);

                        Listdatos.add(new Articulos (
                                articulos.getInt("ID_PROD"),
                            articulos.getString("NOMBRE"),
                                    articulos.getString("DESCRIPCION"),
                                    articulos.getString("FOTO")

                        ));
                    }


                    AdaptadorLista adaptadorLista = new AdaptadorLista(MainActivity.this, Listdatos);
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

}