package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Bai2 extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword;
    Intent intentSignup;
    ImageView imvRegister;

    private void setupProcess() {
        setupCreateAccount();
    }

    public void setupCreateAccount() {
        imvRegister.setOnClickListener(v -> {
            try {
                String name = edtName.getText().toString(),
                        email = edtEmail.getText().toString(),
                        passw = edtPassword.getText().toString();

                if (name.length() == 0 || email.length() == 0 || passw.length() == 0) {
                    Toast.makeText(this, "Nhap lai", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    loadRegister();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void loadRegister() {
        intentSignup = new Intent(Bai2.this, Bai1.class);
        startActivity(intentSignup);
    }

    private void setupUI() {
        edtName = findViewById(R.id.editTextText3);
        edtEmail = findViewById(R.id.editTextText4);
        edtPassword = findViewById(R.id.editTextText5);
        imvRegister = findViewById(R.id.imageButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        setupUI();
        setupProcess();
    }
}