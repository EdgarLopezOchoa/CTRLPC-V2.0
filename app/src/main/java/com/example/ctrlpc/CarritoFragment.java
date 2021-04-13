package com.example.ctrlpc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarritoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarritoFragment extends Fragment {

    List<CarritoBD> Listcarrito;


    RecyclerView recyclerView;



    String articulo = InicioFragment.Articulo;

    int accion = InicioFragment.Accion;

    RequestQueue requestQueue;


   String titulo = AdaptadorLista.titulo;
   String descripcion = AdaptadorLista.descripcion;
   String precio = AdaptadorLista.precio;
   String imagen = AdaptadorLista.imagen;
   String id = AdaptadorLista.id;
   String email = Login.Correo;
   public static int permiso = AdaptadorLista.permiso;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarritoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarritoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarritoFragment newInstance(String param1, String param2) {
        CarritoFragment fragment = new CarritoFragment();
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
        View view = inflater.inflate(R.layout.fragment_carrito, container, false);
try {
    Registrararticulo("https://carlosarmenta.000webhostapp.com/ctrlpc/registro_articulos.php");


    Listcarrito = new ArrayList<>();

    recyclerView = view.findViewById(R.id.RVcarritoCompras);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));





    CargarArticuloscarrito("https://carlosarmenta.000webhostapp.com/ctrlpc/carrito.php?EMAIL=" + email);
} catch (Exception e) {

}


        return view;
    }

    public void Registrararticulo(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String > getParams() throws AuthFailureError {
                Map<String, String > parametros= new HashMap<String, String>();
                parametros.put("NOMBRES",titulo);
                parametros.put("PRECIO",precio);
                parametros.put("DESCRIPCION",descripcion);
                parametros.put("FOTO",imagen);
                parametros.put("ID",id);
                parametros.put("EMAIL",email);
                return parametros;
            }
        };

        requestQueue=Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
    private void CargarArticuloscarrito(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray array = new JSONArray(response);


                    for (int i = 0; i < array.length(); i++) {

                        JSONObject carrito = array.getJSONObject(i);

                        Listcarrito.add(new CarritoBD(
                                carrito.getString("NOMBRE"),
                                carrito.getString("DESCRIPCION"),
                                carrito.getString("FOTO"),
                                carrito.getString("PRECIO"),
                                carrito.getInt("ID_PROD")




                        ));

                    }


                    AdaptadorCarrito adaptadorCarrito = new AdaptadorCarrito(Listcarrito);
                    recyclerView.setAdapter(adaptadorCarrito);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

                new Response.ErrorListener(){


                    public void onErrorResponse(VolleyError error){

                    }

                });

        Volley.newRequestQueue(getContext()).add(stringRequest);

    }


}