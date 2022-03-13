package com.example.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    private TextView text_cadastro;
    private Button btn_Entrar;
    private ProgressBar barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);


        getSupportActionBar().hide();

        btn_Entrar = findViewById(R.id.btn_entrar);
        text_cadastro = findViewById(R.id.txt_cadastro);
        barra = findViewById(R.id.barra_processo);

        barra.setVisibility(View.VISIBLE);
        btn_Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this,PrincipalScreen.class);
                        startActivity(intent);

            }
        });

         text_cadastro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FormLogin.this,FormRegister.class);
               startActivity(intent);
        }

    }
    );

    }



//Final of program
}