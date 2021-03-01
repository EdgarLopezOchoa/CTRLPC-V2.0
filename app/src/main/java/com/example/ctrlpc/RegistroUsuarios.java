package com.example.ctrlpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroUsuarios extends AppCompatActivity {

    TextView cuenta;
    TextView Cancelarregistro;
    CheckBox contraseña;
    EditText ETcontraseña;

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

}