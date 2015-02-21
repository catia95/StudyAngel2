package com.studyangel.secretsix.studyangel;

/**
 * Created by chryziaitay on 08/02/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SplashScreen extends Activity {

    ImageView imageVar;
    AnimationDrawable Anim;
    private Thread mSplashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        final SplashScreen splashScreen = this;
        imageVar = (ImageView) findViewById(R.id.image);
        mSplashThread =  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        //amount of time before it goes to dashboard
                        wait(3000);
                    }
                }
                catch(InterruptedException ex){
                }

                finish();

                //directs to the dashboard
                Intent intent = new Intent();
                intent.setClass(splashScreen, MainActivity.class);
                startActivity(intent);

            }
        };

        mSplashThread.start();

        try {
            BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.splash_frame1);
            BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.splash_frame2);
            BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(
                    R.drawable.splash_frame3);
            //create animation
            Anim = new AnimationDrawable();
            //Anim.addFrame(frame number, duration of frame);
            Anim.addFrame(frame1, 100);
            Anim.addFrame(frame2, 700);
            Anim.addFrame(frame3, 600);
            Anim.addFrame(frame1, 500);
            //amount of time for fading a frame
            Anim.setExitFadeDuration(500);
            //describes whether animation is run only once or repeated
            Anim.setOneShot(false);
            imageVar.setBackgroundDrawable(Anim);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {

                    Anim.start();

                } //amount of time each animation (1 set of frame) lasts
            }, 100);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    //not yet sure what this does
    public boolean onTouchEvent(MotionEvent evt)
    {
        if(evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized(mSplashThread){
                mSplashThread.notifyAll();
            }
        }
        return true;
    }
}