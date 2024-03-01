package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bai1 extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    ImageView imvLogin;
    Button btnLogin;
    TextView tvRegister;
    Intent intentLogin, intentRegister;

    private void setupProcess() {
        setupLogin();
        setupRegister();
    }

    public void setupRegister() {
        tvRegister.setOnClickListener(v -> {
            intentRegister = new Intent(Bai1.this, Bai2.class);
            startActivity(intentRegister);
        });
    }


    public void setupLogin() {
        imvLogin.setOnClickListener(v -> {
            try {
                String email = edtEmail.getText().toString(), password = edtPassword.getText().toString();
                if (email.equals("admin") && password.equals("admin")) {
                    Toast.makeText(this, "oke", Toast.LENGTH_SHORT).show();
                    intentLogin = new Intent(Bai1.this, MainActivity.class);
                    startActivity(intentLogin);
                } else {
                    Toast.makeText(this, "sai tai khoan or pass word", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

    }

    public void setupUI() {
        edtEmail = findViewById(R.id.editTextText);
        edtPassword = findViewById(R.id.editTextText2);
        imvLogin = findViewById(R.id.imageButton8);
        tvRegister = findViewById(R.id.textView6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        setupUI();
        setupProcess();
    }
}