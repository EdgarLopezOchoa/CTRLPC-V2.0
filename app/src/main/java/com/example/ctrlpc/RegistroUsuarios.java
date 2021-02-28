package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegistroUsuarios extends AppCompatActivity {

    TextView cuenta;
    TextView Cancelarregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        getSupportActionBar().hide();
        cuenta = findViewById(R.id.TVyatengocuenta);
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
                Intent intent =  new Intent(getApplicationContext(), Login.class);
                startActivity(intent);


            }
        });
    }
}