package com.example.my_therapy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    //Hooks
    View second_pill, third_pill;
//    TextView a ;


    //Animation
    Animation topAnimation, middleAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(getApplicationContext(), Login.class));             //after 500 milliseconds this block calls the mainActivity
                finish();
            }
        }, secondsDelayed * 2000);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        middleAnimation= AnimationUtils.loadAnimation(this,R.anim.middle_animation);
        //Hooks
        second_pill= findViewById(R.id.second_pill);
        third_pill=findViewById(R.id.third_pill);
        //a=findViewById(R.id.a);


        second_pill.setAnimation(topAnimation);
        third_pill.setAnimation(topAnimation);

      //  a.setAnimation(middleAnimation);

    }
}