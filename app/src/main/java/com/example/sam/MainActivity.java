package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private Button texteBtn;
    private Button morseBtn;
    private Button brailleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texteBtn = (Button) findViewById(R.id.texteB);
        morseBtn = (Button) findViewById(R.id.morseB);
        brailleBtn = (Button) findViewById(R.id.brailleB);

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openActTexte();
            }
        });

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openActMorse();
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openActBraille();
            }
        });
    }

    private void openActTexte() {
        Intent intent = new Intent(this, TexteMenu.class);
        startActivity(intent);
    }

    private void openActMorse() {
        Intent intent = new Intent(this, MorseMenu.class);
        startActivity(intent);
    }

    private void openActBraille() {
        Intent intent = new Intent(this, BrailleMenu.class);
        startActivity(intent);
    }



}



