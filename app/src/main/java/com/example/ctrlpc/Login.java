package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private int DURATION_SPLACH = 3000;


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
                OpenDialoglogin();
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

    public void cerrarlogin(View view)
    {
        Login login = new Login();
        login.finish();
        RegistroUsuarios registroUsuarios = new RegistroUsuarios();
        registroUsuarios.finish();
    }

}