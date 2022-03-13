package com.example.projetofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormRegister extends AppCompatActivity {

    private EditText mNome, mEmail, mSenha;
    private Button mBtnCadastrar;
    String[] mensagens = {"Preencha todos os campos",
                          "Cadastro realizado com sucesso"

                                                    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);

        getSupportActionBar().hide();
        iniciarComponenetes();

        mBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = mNome.getText().toString();
                String email = mEmail.getText().toString();
                String senha =  mSenha.getText().toString();
                //Validar se todos os campos estão corretos
                if (nome.isEmpty()||email.isEmpty()||senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    cadastrarUsuario(view);
                }
            }
        });

    }

    private void cadastrarUsuario(View view){
        String senha = mSenha.getText().toString();
        String email =  mEmail.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[1], Snackbar.LENGTH_LONG);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.show();
                }
            }
        });

    }

    private void iniciarComponenetes() {
        mNome = findViewById(R.id.edit_CNome);
        mEmail = findViewById(R.id.edit_CEmail);
        mSenha =  findViewById(R.id.edit_CSenha);
        mBtnCadastrar = findViewById(R.id.btn_cadastrar);
    }

}