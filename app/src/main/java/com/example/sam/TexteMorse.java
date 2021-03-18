package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TexteMorse extends AppCompatActivity {

    private EditText in_texte_morse;
    private TextView out_texte_morse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_texte_morse);

        Intent intent = getIntent();
    }

    public void valid_texte_morse(View view) {
        in_texte_morse = (EditText) findViewById(R.id.in_texte_braille);
        out_texte_morse = (TextView) findViewById(R.id.out_texte_braille);
        out_texte_morse.setText(Traducteur.latinToMorse(in_texte_morse.getText().toString()));
    }

    public void by_sound(View view) {
        if(out_texte_morse.getText().toString() != null) {
            MorseReader.sound(out_texte_morse.getText().toString());
        }
    }

    public void by_flash(View view) {
        if(out_texte_morse.getText().toString() != null) {
            MorseReader.flash(out_texte_morse.getText().toString());
        }
    }

    public void by_vibration(View view) {
        if(out_texte_morse.getText().toString() != null) {
            MorseReader.vibrator(out_texte_morse.getText().toString());
        }
    }
}
