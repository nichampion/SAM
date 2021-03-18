package com.example.sam;


import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import androidx.appcompat.app.AppCompatActivity;

import static androidx.core.content.ContextCompat.getSystemService;

public abstract class MorseReader {
    static Vibrator vibrator;
    static CameraManager cam;

    static void wait(int time_ms) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ********** Flash **********

    static void setFlasher(CameraManager c) {
        cam = c;
    }

    static void flashLightOn() {
        try {
            String cameraId = cam.getCameraIdList()[0];
            cam.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {}
    }

    static void flashLightOff() {
        try {
            String cameraId = cam.getCameraIdList()[0];
            cam.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {}
    }

    static void longFlash() {
        flashLightOn();
        wait(500);
        flashLightOff();
    }

    static void shortFlash() {
        flashLightOn();
        wait(80);
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
            wait(100);
        }
    }

    // ********** Vibrator **********
    static void setVibrator(Vibrator v) {
        vibrator = v;
    }

    static void vibrate(int time_ms) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            vibrator.vibrate(VibrationEffect.createOneShot(time_ms, VibrationEffect.DEFAULT_AMPLITUDE));
        else
            vibrator.vibrate(500); //deprecated in API 26
        wait(time_ms);
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
        beep(300);
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