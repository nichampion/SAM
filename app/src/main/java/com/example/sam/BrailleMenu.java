package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BrailleMenu extends HomeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_braille_menu);

        texteBtn = (Button) findViewById(R.id.texteB3);
        morseBtn = (Button) findViewById(R.id.morseB3);
        selection = "";

        swBtn = (ImageButton) findViewById(R.id.swipeB);

        Intent intent = getIntent();

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "BRAILLETEXTE";
                cleanButton();
                pressButton(texteBtn);
                validSelection(selection);
            }
        });

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "BRAILLEMORSE";
                cleanButton();
                pressButton(morseBtn);
                validSelection(selection);
            }
        });
    }

}
