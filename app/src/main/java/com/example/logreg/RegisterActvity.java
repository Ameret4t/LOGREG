package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActvity extends AppCompatActivity {

    private EditText felhasznalonev;
    private EditText jelszo;
    private EditText email;
    private EditText teljesnev;
    private Button regisztracio;
    private Button vissza;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_actvity);
        init();
        vissza.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent elso = new Intent(RegisterActvity.this,
                        MainActivity.class);
                startActivity(elso);
                finish();
            }
        });
        regisztracio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if ((TextUtils.isEmpty((CharSequence) felhasznalonev) || TextUtils.isEmpty((CharSequence) jelszo) || TextUtils.isEmpty((CharSequence) email ) || TextUtils.isEmpty((CharSequence) teljesnev))){
                    Toast.makeText(RegisterActvity.this, "Nem hagyhat uresen mezot", Toast.LENGTH_SHORT).show();
                }else if((email.getText().toString().trim().matches(emailPattern))){
                    Toast.makeText(RegisterActvity.this, "Ervenytelen email cim!", Toast.LENGTH_SHORT).show();
                }
                else{
                    DBHelper h = new DBHelper(null, null, null, 1);
                    if (h.adatRogzites(email.getText().toString(), felhasznalonev.getText().toString(), jelszo.getText().toString(), teljesnev.getText().toString())){
                        h.adatRogzites(email.getText().toString(), felhasznalonev.getText().toString(), jelszo.getText().toString(), teljesnev.getText().toString());
                        Toast.makeText(RegisterActvity.this, "Sikeres felvetel", Toast.LENGTH_SHORT).show();}
                    else{Toast.makeText(RegisterActvity.this, "Sikertelen felvetel", Toast.LENGTH_SHORT).show();}}

            }
        });
        }


    private void init() {
        felhasznalonev = findViewById(R.id.felhasznalonev);
        jelszo = findViewById(R.id.jelszo);
        email = findViewById(R.id.email);
        teljesnev = findViewById(R.id.teljesnev);

        regisztracio = findViewById(R.id.regisztracio);
        vissza = findViewById(R.id.vissza);
    }




}