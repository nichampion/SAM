package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MorseBraille extends AppCompatActivity {

    private TextView in_morse_braille;
    private TextView out_morse_braille;
    private String mot;
    private List<String> mots = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_morse_braille);

        Intent intent = getIntent();

        mot = "";

    }

    public void click_trait(View view) {
        in_morse_braille = (TextView) findViewById(R.id.in_morse_braille);
        mot+='-';
        String temp = "";
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_braille.setText(temp + " " + mot);
    }

    public void click_point(View view) {
        in_morse_braille = (TextView) findViewById(R.id.in_morse_braille);
        mot+='·';
        String temp = "";
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_braille.setText(temp + " " + mot);
    }


    public void click_stop(View view) {
        in_morse_braille = (TextView) findViewById(R.id.in_morse_braille);
        out_morse_braille = (TextView) findViewById(R.id.out_morse_braille);
        mots.add(mot);
        String temp = "";
        String temp1 = "";
        for(String m : mots){
            temp += Traducteur.morseToBraille(m);
            temp1 += m;
        }
        out_morse_braille.setText(temp);
        mot = "";
    }

    public void click_restart(View view) {
        in_morse_braille = (TextView) findViewById(R.id.in_morse_braille);
        out_morse_braille = (TextView) findViewById(R.id.out_morse_braille);
        mot = "";
        mots = new ArrayList<String>();
        in_morse_braille.setText(mot);
        out_morse_braille.setText(mot);
    }

    public void click_annuler(View view) {
        mot = "";
        in_morse_braille = (TextView) findViewById(R.id.in_morse_braille);
        String temp = "";
        if (mots != null && !mots.isEmpty()) {
            String item = mots.get(mots.size()-1);
        }
        for(String m : mots){
            temp += m;
            temp += " ";
        }
        in_morse_braille.setText(temp + " " + mot);
    }
}