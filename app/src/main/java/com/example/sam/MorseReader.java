package com.example.testsam;


import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import static androidx.core.content.ContextCompat.getSystemService;

public class MorseReader<synchronised> {

    static void wait(int time_ms) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            else
                wait(100);
        }
    }

    // ********** Vibrator **********

    static void vibrate(int time_ms) {
        /*Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            v.vibrate(VibrationEffect.createOneShot(time_ms, VibrationEffect.DEFAULT_AMPLITUDE));
        else
            v.vibrate(500); //deprecated in API 26
        wait(time_ms);*/
    }

    static void longVibration() {
        vibrate(250);
    }

    static  void shortVibration() {
        vibrate(125);
    }

    public static void vibrator(String chaine) {
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            if(c == '-')
                longVibration();
            else if(c == '·')
                shortVibration();
            else
                wait(100);
        }
    }

    // ********** Sound **********

    static void beep(int time_ms) {
        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen1.startTone(ToneGenerator.TONE_DTMF_1, time_ms);
        wait(time_ms);
    }

    static void longSound() {
        beep(250);
    }

    static void shortSound() {
        beep(125);
    }

    public static void sound(String chaine) {
        char c;

        for(int i = 0; i < chaine.length(); i++) {
            c = chaine.charAt(i);

            if(c == '-')
                longSound();
            else if(c == '·')
                shortSound();
            else
                wait(100);
        }
    }

}
