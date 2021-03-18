package com.example.sam;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class DetectSwipeLectureListener extends GestureDetector.SimpleOnGestureListener {

    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static int MIN_SWIPE_DISTANCE_Y = 100;

    private static int MAX_SWIPE_DISTANCE_X = 1000;
    private static int MAX_SWIPE_DISTANCE_Y = 1000;

    private HomeActivity activity = null;
    private ActivitySwitcher switcher = new ActivitySwitcher();


    public void setActivity(HomeActivity act){
        this.activity = act;
    }

    public void setActivitySwitcher2(ActivitySwitcher switcher){
        this.switcher = switcher;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
        float deltaX = e1.getX() - e2.getX();

        float deltaXAbs = Math.abs(deltaX);

        if(deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X){
            if(deltaX < 0){
                switcher.setContextSwitcher(this.activity.getCont());
                switcher.changeActivityBySwipe(this.activity.getSel());
            }
        }

        return true;
    }

}
