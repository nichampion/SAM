package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MorseMenu extends AppCompatActivity {

    private Button texteBtn;
    private Button brailleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_morse_menu);

        texteBtn = (Button) findViewById(R.id.texteB2);
        brailleBtn = (Button) findViewById(R.id.brailleB2);

        Intent intent = getIntent();

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openMorseTexte();
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openMorseBraille();
            }
        });
    }

    private void openMorseTexte() {
        Intent intent = new Intent(this, MorseTexte.class);
        startActivity(intent);
    }

    private void openMorseBraille() {
        Intent intent = new Intent(this, MorseBraille.class);
        startActivity(intent);
    }


}
