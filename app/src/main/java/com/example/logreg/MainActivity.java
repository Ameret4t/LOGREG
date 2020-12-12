package com.example.logreg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText felhasznalonev;
    private EditText jelszo;
    private Button bejelentkezes;
    private Button regisztracio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        regisztracio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent elso = new Intent(MainActivity.this,
                        RegisterActvity.class);
                startActivity(elso);
                finish();
            }
        });
        bejelentkezes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent masodik = new Intent(MainActivity.this,
                        LoggedInActivity.class);
                startActivity(masodik);
                finish();
            }
        })
    ;}

    private void init() {
        felhasznalonev = findViewById(R.id.felhasznalonev);
        jelszo = findViewById(R.id.jelszo);
        bejelentkezes = findViewById(R.id.bejelentkezes);
        regisztracio = findViewById(R.id.regisztracio);
    }



    /*public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.regisztracio:
                Intent Register = new Intent(MainActivity.this,
                        RegisterActvity.class);

                startActivity(Register);
                finish();

        }
    }*/
}


