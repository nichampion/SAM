package com.example.sam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BrailleTexte extends AppCompatActivity {

    private TextView out_braille_texte;
    private TextView in_braille_texte;

    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private CheckBox c5;
    private CheckBox c6;

    private String mot;
    private List<String> mots = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_braille_texte);

        Intent intent = getIntent();

        out_braille_texte = (TextView) findViewById(R.id.out_braille_texte);
        c1 = (CheckBox) findViewById(R.id.bt_cb1);
        c2 = (CheckBox) findViewById(R.id.bt_cb2);
        c3 = (CheckBox) findViewById(R.id.bt_cb3);
        c4 = (CheckBox) findViewById(R.id.bt_cb4);
        c5 = (CheckBox) findViewById(R.id.bt_cb5);
        c6 = (CheckBox) findViewById(R.id.bt_cb6);

        mot = "";
    }

    public void espacer(View view) {
        if(mots != null){
            mots.add(" ");
        }
    }

    public void valider_caract(View view) {
        String tempo = "";
        tempo = BrailleGetter.get(c1.isChecked(),c2.isChecked(),c3.isChecked(),c4.isChecked(),c5.isChecked(),c6.isChecked());
        if(tempo != null) {
            mot += tempo;
        }
    }

    public void click_annuler(View view) {
        mot = "";
        in_braille_texte = (TextView) findViewById(R.id.in_braille_texte);
        String temp = "";
        if (mots != null && !mots.isEmpty()) {
            String item = mots.get(mots.size()-1);
        }
        for(String m : mots){
            temp += m;
        }
        in_braille_texte.setText(temp + " " + mot);
    }

    public void click_restart(View view) {
        in_braille_texte = (TextView) findViewById(R.id.in_braille_texte);
        out_braille_texte = (TextView) findViewById(R.id.out_braille_texte);
        mot = "";
        mots = new ArrayList<String>();
        in_braille_texte.setText(mot);
        out_braille_texte.setText(mot);
    }

    public void valider_saisie(View view) {
        in_braille_texte = (TextView) findViewById(R.id.in_braille_texte);
        out_braille_texte = (TextView) findViewById(R.id.out_braille_texte);

        if(mot != null){
            mots.add(mot);
        }

        String temp = "";
        String in = "";
        String temp1 = "";
        if(mots != null){
            for(String m : mots){
                try{
                    if(Traducteur.brailleToLatin(m) != null){
                        temp += Traducteur.brailleToLatin(m);

                        in += m;
                        temp1 += m;
                        in_braille_texte.setText(in);
                        out_braille_texte.setText(temp);
                    }
                } catch (Exception e) {}
            }
            mot = "";
        }
    }
}
