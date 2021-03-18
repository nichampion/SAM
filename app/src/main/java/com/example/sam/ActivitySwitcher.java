package com.example.sam;

import android.content.Context;
import android.content.Intent;

public class ActivitySwitcher {

    private String selection;
    private Context context;

    public ActivitySwitcher(){
        this.selection = new String("");
    }

    public void changeActivityBySwipe(String sel){
        if(sel != null) {
          openActSelect(sel);
        }
    }

    public void setActivitySwitcher(String sel) {
        this.selection = sel;
    }

    public void setContextSwitcher(Context cont) {
        this.context = cont;
    }

    private void openActSelect(String sel) {
        switch (sel){
            case "TEXTE" :
                openActTexte();
                break;
            case "TEXTEMORSE" :
                openTexteMorse();
                break;
            case "TEXTEBRAILLE" :
                openTexteBraille();
                break;
            case "MORSE" :
                openActMorse();
                break;
            case "MORSETEXTE" :
                openMorseTexte();
                break;
            case "MORSEBRAILLE" :
                openMorseBraille();
                break;
            case "BRAILLE" :
                openActBraille();
                break;
            case "BRAILLETEXTE" :
                openBrailleTexte();
                break;
            case "BRAILLEMORSE" :
                openBrailleMorse();
                break;

        }
    }

    private void openActTexte() {
        Intent intent = new Intent(this.context , TexteMenu.class);
        this.context.startActivity(intent);
    }

    private void openActMorse() {
        Intent intent = new Intent(this.context, MorseMenu.class);
        this.context.startActivity(intent);
    }

    private void openActBraille() {
        Intent intent = new Intent(this.context, BrailleMenu.class);
        this.context.startActivity(intent);
    }

    private void openTexteMorse() {
        Intent intent = new Intent(this.context, TexteMorse.class);
        this.context.startActivity(intent);
    }

    private void openTexteBraille() {
        Intent intent = new Intent(this.context, TexteBraille.class);
        this.context.startActivity(intent);
    }

    private void openMorseTexte() {
        Intent intent = new Intent(this.context, MorseTexte.class);
        this.context.startActivity(intent);
    }

    private void openMorseBraille() {
        Intent intent = new Intent(this.context, MorseBraille.class);
        this.context.startActivity(intent);
    }

    private void openBrailleTexte() {
        Intent intent = new Intent(this.context, BrailleTexte.class);
        this.context.startActivity(intent);
    }

    private void openBrailleMorse() {
        Intent intent = new Intent(this.context, BrailleMorse.class);
        this.context.startActivity(intent);
    }

    public String getSel() {
        return this.selection;
    }
}
