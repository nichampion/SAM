package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MorseTexte extends AppCompatActivity {

    private TextView in_morse_texte;
    private TextView out_morse_texte;
    private String mot;
    private List<String> mots = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_morse_texte);

        Intent intent = getIntent();

        mot = "";

    }

    public void click_trait(View view) {
        in_morse_texte = (TextView) findViewById(R.id.in_morse_texte);
        mot+='-';
        String temp = "";
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_texte.setText(temp + " " + mot);
    }

    public void click_point(View view) {
        in_morse_texte = (TextView) findViewById(R.id.in_morse_texte);
        mot+='·';
        String temp = "";
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_texte.setText(temp + " " + mot);
    }


    public void click_stop(View view) {
        in_morse_texte = (TextView) findViewById(R.id.in_morse_texte);
        out_morse_texte = (TextView) findViewById(R.id.out_morse_texte);
        mots.add(mot);
        String temp = "";
        String temp1 = "";
        for(String m : mots){
            temp += Traducteur.morseToLatin(m);
            temp1 += m;
        }
        out_morse_texte.setText(temp);
        mot = "";
    }

    public void click_restart(View view) {
        in_morse_texte = (TextView) findViewById(R.id.in_morse_texte);
        out_morse_texte = (TextView) findViewById(R.id.out_morse_texte);
        mot = "";
        mots = new ArrayList<String>();
        in_morse_texte.setText(mot);
        out_morse_texte.setText(mot);
    }

    public void click_annuler(View view) {
        mot = "";
        in_morse_texte = (TextView) findViewById(R.id.in_morse_texte);
        String temp = "";
        if (mots != null && !mots.isEmpty()) {
            String item = mots.get(mots.size()-1);
        }
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_texte.setText(temp + " " + mot);
    }
}
