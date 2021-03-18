package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TexteBraille extends AppCompatActivity {

    private EditText in_texte_braille;
    private TextView out_texte_braille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_texte_braille);

        Intent intent = getIntent();

    }

    public void valid_texte_braille(View view) {
        in_texte_braille = (EditText) findViewById(R.id.in_texte_braille);
        out_texte_braille = (TextView) findViewById(R.id.out_texte_braille);
        out_texte_braille.setText(Traducteur.latinToBraille(in_texte_braille.getText().toString()));
    }
}