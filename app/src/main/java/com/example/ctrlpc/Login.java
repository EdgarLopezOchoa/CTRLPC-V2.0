package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.navigation.Navigation.findNavController;

public class Login extends AppCompatActivity {

    Button botonregistro;
    Dialog dialog;
    Button botoninicio;
    EditText email;
    EditText password;
    TextView asterisco1;
    TextView asterisco2;
    TextView CancelarLogin;

    CheckBox MostrarC;
    private int DURATION_SPLACH = 3000;
    RequestQueue requestQueue;

    List<CuentaBD> Listusuarios;

    public static String Correo;

    public  static String Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

    botonregistro = findViewById(R.id.BTNregistro);
    botoninicio = findViewById(R.id.BNiniciarsesion);
    email = findViewById(R.id.ETemail);
    password = findViewById(R.id.ETpassword);
    asterisco1 = findViewById(R.id.TVasterisco);
    asterisco2 = findViewById(R.id.TVasterisco2);
    MostrarC = findViewById(R.id.CBmostrarContraseñalogin);
        dialog = new Dialog(this);




        MostrarC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MostrarC.isChecked()==true){
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                }
                else if (MostrarC.isChecked()== false)
                {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });


botoninicio.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Verificarlogin();



        if (email.getText().toString().isEmpty()) {

            asterisco1.setVisibility(View.VISIBLE);
            asterisco1.setTextColor(Color.RED);
            Toast.makeText(getApplicationContext(),"Rellena Los Campos Marcados",Toast.LENGTH_LONG).show();

        }
        else{
            asterisco1.setVisibility(View.GONE);
            if (password.getText().toString().isEmpty()) {

                asterisco2.setVisibility(View.VISIBLE);
                asterisco2.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(),"Rellena Los Campos Marcados",Toast.LENGTH_LONG).show();
            }
            else{
                asterisco2.setVisibility(View.GONE);
                loginusuarios("https://carlosarmenta.000webhostapp.com/ctrlpc/buscar_usuario.php");
            }
        }



    }
});
        CancelarLogin = findViewById(R.id.TVcancelarlogin);
        CancelarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*finish();*/

               Intent intent =  new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                /*FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.navigation_configuracion,new ConfiguracionFragment()).commit();

                findNavController(v).navigate(R.id.action_navigation_LoginActivity_to_navigation_configuracion);*/



            }
        });
        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenDialogregistro();

            }
        });
    }



    public void OpenDialogregistro(){
        dialog.setContentView(R.layout.cuadro_de_dialogo_registro);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView IMclose = dialog.findViewById(R.id.IMclose);
        Button BTNusuario = dialog.findViewById(R.id.BTNusuario);
        Button BTNempresa = dialog.findViewById(R.id.BTNempresa);
        dialog.show();


        IMclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        BTNusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(),RegistroUsuarios.class);
                startActivityForResult(intent,0);
                dialog.dismiss();
            }
        });
    }

    public void OpenDialoglogin(){

        dialog.setContentView(R.layout.dialogo_de_carga);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
                dialog.dismiss();finish();
            };

        }, DURATION_SPLACH);
    }


    public void Verificarlogin()
    {
        if (email.getText().toString().isEmpty()) {

            asterisco1.setVisibility(View.VISIBLE);
            asterisco1.setTextColor(Color.RED);
            Toast.makeText(getApplicationContext(),"Rellena Los Campos Marcados",Toast.LENGTH_LONG).show();

        }
        else{
            asterisco1.setVisibility(View.GONE);

        }
        if (password.getText().toString().isEmpty()) {

            asterisco2.setVisibility(View.VISIBLE);
            asterisco2.setTextColor(Color.RED);
            Toast.makeText(getApplicationContext(),"Rellena Los Campos Marcados",Toast.LENGTH_LONG).show();
        }
        else{
            asterisco2.setVisibility(View.GONE);
        }
    }



    public void loginusuarios(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(!response.isEmpty()){
                    
                    Correo = email.getText().toString();
                    Password = password.getText().toString();

                  OpenDialoglogin();
                    Limpiarformulario();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Los Datos Ingresados Son Incorrectos,Favor De Verificar",
                            Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "A Ocurrido Un Error, No Se A Podido Iniciar Sesion", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String > getParams() throws AuthFailureError {
                Map<String, String > parametros= new HashMap<String, String>();
                parametros.put("EMAIL",email.getText().toString());
                parametros.put("CONTRASEÑA",password.getText().toString());
                return parametros;
            }
        };

        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void Limpiarformulario() {
        email.setText("");
        password.setText("");
    }


}