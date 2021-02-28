package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button botonregistro;
    Dialog dialog;
    Button botoninicio;
    EditText email;
    EditText password;
    TextView asterisco1;
    TextView asterisco2;
    TextView CancelarLogin;


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
        dialog = new Dialog(this);

botoninicio.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

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
});
        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialog();
            }
        });
    }
    public void OpenDialog(){
        dialog.setContentView(R.layout.cuadro_de_dialogo_registro);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ImageView IMclose = dialog.findViewById(R.id.IMclose);
        Button BTNusuario = dialog.findViewById(R.id.BTNusuario);
        Button BTNempresa = dialog.findViewById(R.id.BTNempresa);
        dialog.show();
        CancelarLogin = findViewById(R.id.TVcancelarLogin);
        CancelarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), ConfiguracionFragment.class);
                startActivity(intent);
            }
        });
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

}