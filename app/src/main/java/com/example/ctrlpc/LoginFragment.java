package com.example.ctrlpc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button iniciar;

        iniciar = view.findViewById(R.id.BNiniciarsesion);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText correo;
                TextView asterisco1;
                TextView asterisco2;
                EditText password;

                asterisco1 = view.findViewById(R.id.TVasterisco);

                asterisco2 = view.findViewById(R.id.TVasterisco2);

                correo = view.findViewById(R.id.ETemail);

                password = view.findViewById(R.id.ETpassword);


                if (correo.getText().toString().isEmpty()){
                    correo.setHintTextColor(getResources().getColor(R.color.rojo));
                    asterisco1.setVisibility(View.VISIBLE);
                    asterisco1.setTextColor(getResources().getColor(R.color.rojo));

                }
                if (password.getText().toString().isEmpty()){
                   password.setHintTextColor(getResources().getColor(R.color.rojo));
                    asterisco2.setVisibility(View.VISIBLE);
                    asterisco2.setTextColor(getResources().getColor(R.color.rojo));
                }
            }
        });





        // Inflate the layout for this fragment



        /*Button registro;
        registro = view.findViewById(R.id.BTNregistro);
        LoadingDialogo loadingDialogo = new LoadingDialogo(LoginFragment.this);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialogo.LoadingAlert();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialogo.dismissdialogo();
                    }
                }, 5000);
            }
        });*/

        return view;
    }
}