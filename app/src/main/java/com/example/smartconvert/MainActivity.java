package com.example.smartconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_open;
    Button btn_openS;
    ImageButton btn_open2;
    Button btn_open2S;
    ImageButton btn_open3;
    Button btn_open3S;
    ImageButton btn_open4;
    Button btn_open4S;
    Button btn_apropos;
    Button btn_fermer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_open  = findViewById(R.id.longeur);
        btn_openS  = findViewById(R.id.longeurS);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texteAEnvoyer = "Bonjour depuis Activity1";
                Intent intent = new Intent(MainActivity.this, longeur.class);
                intent.putExtra("CLE_TEXTE", texteAEnvoyer);
                startActivity(intent);
            }
       });
        btn_openS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texteAEnvoyer = "Bonjour depuis Activity1";
                Intent intent = new Intent(MainActivity.this, longeur.class);
                intent.putExtra("CLE_TEXTE", texteAEnvoyer);
                startActivity(intent);
            }
        });


        btn_open2  = findViewById(R.id.masse);
        btn_open2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, masse.class);
                startActivity(intent);
            }
        });

        btn_open2S  = findViewById(R.id.masseS);
        btn_open2S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, masse.class);
                startActivity(intent);
            }
        });


        btn_open3  = findViewById(R.id.temp);
        btn_open3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, temperature.class);
                startActivity(intent);
            }
        });

        btn_open3S  = findViewById(R.id.tempS);
        btn_open3S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, temperature.class);
                startActivity(intent);
            }
        });

        btn_open4  = findViewById(R.id.devis);
        btn_open4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, devise.class);
                startActivity(intent);
            }
        });

        btn_open4S  = findViewById(R.id.devisS);
        btn_open4S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, devise.class);
                startActivity(intent);
            }
        });

        btn_apropos  = findViewById(R.id.apropos);
        btn_apropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AProposActivity.class);
                startActivity(intent);
            }
        });

        btn_fermer = (Button)findViewById(R.id.quitter);
        btn_fermer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}