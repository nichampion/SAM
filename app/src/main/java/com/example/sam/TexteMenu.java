package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TexteMenu extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_texte_menu);

        morseBtn = (Button) findViewById(R.id.morseB1);
        brailleBtn = (Button) findViewById(R.id.brailleB1);
        selection = "";

        swBtn = (ImageButton) findViewById(R.id.swipeB);

        Intent intent = getIntent();

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "TEXTEMORSE";
                cleanButton();
                pressButton(morseBtn);
                validSelection(selection);
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "TEXTEBRAILLE";
                cleanButton();
                pressButton(brailleBtn);
                validSelection(selection);
            }
        });
    }
}