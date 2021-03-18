package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MorseMenu extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_morse_menu);

        texteBtn = (Button) findViewById(R.id.texteB2);
        brailleBtn = (Button) findViewById(R.id.brailleB2);
        selection = "";

        swBtn = (ImageButton) findViewById(R.id.swipeB);

        Intent intent = getIntent();

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "MORSETEXTE";
                cleanButton();
                pressButton(texteBtn);
                validSelection(selection);
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "MORSEBRAILLE";
                cleanButton();
                pressButton(brailleBtn);
                validSelection(selection);
            }
        });
    }

}
