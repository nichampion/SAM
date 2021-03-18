package com.example.sam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;

public class HomeActivity extends AppCompatActivity {
    protected Button texteBtn;
    protected Button morseBtn;
    protected Button brailleBtn;
    protected String selection;

    protected ImageButton swBtn;
    protected GestureDetectorCompat gestureDetectorCompat;
    protected ActivitySwitcher sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        texteBtn = (Button) findViewById(R.id.texteB);
        morseBtn = (Button) findViewById(R.id.morseB);
        brailleBtn = (Button) findViewById(R.id.brailleB);
        selection = "";

        swBtn = (ImageButton) findViewById(R.id.swipeB);

        DetectSwipeLectureListener gestureListener = new DetectSwipeLectureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

        Intent intent = getIntent();

        texteBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "TEXTE";
                cleanButton();
                pressButton(texteBtn);
                validSelection(selection);
            }
        });

        morseBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "MORSE";
                cleanButton();
                pressButton(morseBtn);
                validSelection(selection);
            }
        });

        brailleBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                swBtn.setVisibility(View.VISIBLE);
                selection = "BRAILLE";
                cleanButton();
                pressButton(brailleBtn);
                validSelection(selection);
            }
        });

    }

    public void validSelection(String sel) {
        ActivitySwitcher sw = new ActivitySwitcher();
        sw.setActivitySwitcher(sel);
    }

    public void pressButton(Button but){
        but.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_select_btn));
    }

    public void cleanButton(){
        texteBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
        morseBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
        brailleBtn.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
    }

    public String getSel() {
        return this.selection;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

        public Context getCont(){
        return this;
    }

}