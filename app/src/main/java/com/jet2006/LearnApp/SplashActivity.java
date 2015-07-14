package com.jet2006.LearnApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.jet2006.LearnApp.R;

public class SplashActivity extends Activity {

    private static final int TIMER = 500;

    private boolean isTouched = false;

    ImageView img;

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        img = (ImageView) findViewById(R.id.img);
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... params) {// 可变数组参数
                try {
                    while (true) {
                        Thread.sleep(TIMER);
                        if (isTouched) break;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            ;

            @Override
            protected void onPostExecute(Integer result) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);

                startActivity(intent);
                SplashActivity.this.finish();
            }

            ;

        }.execute(new Void[]{});

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ShowTouchedEffect();
        }
        return super.onTouchEvent(event);
    }

    private void ShowTouchedEffect() {

        AnimationSet animationSet = new AnimationSet(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(1000);

        animationSet.addAnimation(alphaAnimation);

        img.startAnimation(animationSet);

        isTouched = true;
    }
}
