package com.example.projetofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PrincipalScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_screen);
        getSupportActionBar().hide();


    }
}