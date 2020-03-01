package com.example.fasttechnologies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPASH_TIME_OUT=7000;
    ImageView fastlogo,fasttech,fastpro;
    Animation animFadeIn,animMoveUp,animMoveDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        fastlogo=findViewById(R.id.fastlogo);
        fasttech=findViewById(R.id.fasttech);
        fastpro=findViewById(R.id.fastpro);

        animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        fastlogo.setVisibility(View.VISIBLE);
        fastlogo.startAnimation(animFadeIn);

        animMoveDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_down);
        fasttech.setVisibility(View.VISIBLE);
        fasttech.startAnimation(animMoveDown);

        animMoveUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up);
        fastpro.setVisibility(View.VISIBLE);
        fastpro.startAnimation(animMoveUp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),StartActivity.class));
                finish();
            }
        },SPASH_TIME_OUT);

    }
}
