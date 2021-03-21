package com.example.ctrlpc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticulosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticulosFragment extends Fragment {

    ArrayList<String> listdatos;

    RecyclerView recyclerView;

    List<ArticulosDB> Listdatos;

    String articulo = InicioFragment.Articulo;

    int accion = InicioFragment.Accion;

    RequestQueue requestQueue;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ArticulosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArticulosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticulosFragment newInstance(String param1, String param2) {
        ArticulosFragment fragment = new ArticulosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_articulos, container, false);

        recyclerView = view.findViewById(R.id.RVarticulosBD);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Listdatos = new ArrayList<>();


        traerarticulos(accion);

return view;

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


                    AdaptadorLista adaptadorLista = new AdaptadorLista(Listdatos);
                    recyclerView.setAdapter(adaptadorLista);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getContext(), error.toString(),Toast.LENGTH_SHORT).show();

                    }

                });

        Volley.newRequestQueue(getContext()).add(stringRequest);

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


                    AdaptadorLista adaptadorLista = new AdaptadorLista(Listdatos);
                    recyclerView.setAdapter(adaptadorLista);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(getContext(), error.toString(),Toast.LENGTH_SHORT).show();

                    }

                });

        Volley.newRequestQueue(getContext()).add(stringRequest);

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