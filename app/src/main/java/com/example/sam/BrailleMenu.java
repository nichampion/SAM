package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BrailleMenu extends AppCompatActivity {

    private Button texteBtn;
    private Button morseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_braille_menu);

        texteBtn = (Button) findViewById(R.id.texteB3);
        morseBtn = (Button) findViewById(R.id.morseB3);

        Intent intent = getIntent();

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openBrailleTexte();
            }
        });

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openMainActivity();
            }
        });
    }

    private void openBrailleTexte() {
        Intent intent = new Intent(this, BrailleTexte.class);
        startActivity(intent);
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, BrailleMorse.class);
        startActivity(intent);
    }

}
