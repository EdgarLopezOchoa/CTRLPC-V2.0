package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuarios extends AppCompatActivity {

    TextView cuenta;
    TextView Cancelarregistro;
    CheckBox contraseña;
    EditText ETcontraseña;
    Button BTNregistrar;
    EditText ETnombre;
    EditText ETemail;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        getSupportActionBar().hide();
        cuenta = findViewById(R.id.TVyatengocuentaregistro);
        cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        Cancelarregistro = findViewById(R.id.TVcancelarregistro);
        Cancelarregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent =  new Intent(getApplicationContext(), Login.class);
                startActivity(intent);*/

                finish();

            }
        });


        ETemail = findViewById(R.id.ETemailregistro);
        ETnombre = findViewById(R.id.ETnombreregistro);
        BTNregistrar = findViewById(R.id.BTNregistrarseregistro);
        BTNregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrarempleados("https://carlosarmenta.000webhostapp.com/ctrlpc/registrar_usuarios.php");
            }
        });



        ETcontraseña = findViewById(R.id.ETpasswordregistro);
        contraseña = findViewById(R.id.CBcontraseñaregistro);
        contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contraseña.isChecked()==true){
                    ETcontraseña.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                }
                else if (contraseña.isChecked()== false)
                {
                    ETcontraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    public void Registrarempleados(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "El empleado a sido registrado", Toast.LENGTH_SHORT).show();
                Limpiarformulario();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String > getParams() throws AuthFailureError {
                Map<String, String > parametros= new HashMap<String, String>();
                parametros.put("E-MAIL",ETemail.getText().toString());
                parametros.put("PASSWORD",ETcontraseña.getText().toString());
                parametros.put("NOMBRES",ETnombre.getText().toString());
               /* parametros.put("Apellido2",TVapellido2.getText().toString());
                parametros.put("Email",TVemail.getText().toString());
                parametros.put("Password",TVpassword.getText().toString());
                parametros.put("Telefono",TVtelefono.getText().toString());
                parametros.put("Direccion",TVdireccion.getText().toString());*/
                return parametros;
            }
        };

        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void Limpiarformulario() {
        ETemail.setText("");
        ETnombre.setText("");
        ETcontraseña.setText("");

    }

}