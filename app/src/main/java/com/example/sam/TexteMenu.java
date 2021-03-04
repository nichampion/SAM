package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TexteMenu extends AppCompatActivity {

    private Button morseBtn;
    private Button brailleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_texte_menu);

        morseBtn = (Button) findViewById(R.id.morseB1);
        brailleBtn = (Button) findViewById(R.id.brailleB1);

        Intent intent = getIntent();

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openTexteMorse();
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openTexteBraille();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openTexteMorse() {
        Intent intent = new Intent(this, TexteMorse.class);
        startActivity(intent);
    }

    private void openTexteBraille() {
        Intent intent = new Intent(this, TexteBraille.class);
        startActivity(intent);
    }


}