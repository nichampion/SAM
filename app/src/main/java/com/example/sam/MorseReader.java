package com.example.sam;


import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.os.Vibrator;

import static androidx.core.content.ContextCompat.getSystemService;

public class MorseReader {

    static void wait(int time_ms) {
        (new Handler()).postDelayed(null, time_ms);
    }

    // ********** Flash **********

    static void flashLightOn() {
    }

    static void flashLightOff() {
    }

    static void longFlash() {
        flashLightOn();
        wait(500);
        flashLightOff();
    }

    static void shortFlash() {
        flashLightOn();
        wait(250);
        flashLightOff();
    }

    public static void flash(String chaine) {
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            if(c == '-')
                longFlash();
            else if(c == '·')
                shortFlash();
            wait(10);
        }
    }

    // ********** Vibrator **********

    static void longVibration() {
       // Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
       // v.vibrate(500);
    }

    static  void shortVibration() {
      //  Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
      //  v.vibrate(250);
    }

    public static void vibrator(String chaine) {
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            if(c == '-')
                longVibration();
            else if(c == '·')
                shortVibration();
            wait(10);
        }
    }

    // ********** Sound **********

    static void beep(int time_ms) {
        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, time_ms);
    }

    static void longSound() {
        beep(500);
    }

    static void shortSound() {
        beep(250);
    }

    public static void sound(String chaine) {
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            if(c == '-')
                longSound();
            else if(c == '·')
                shortSound();
            wait(100);
        }
    }

}
