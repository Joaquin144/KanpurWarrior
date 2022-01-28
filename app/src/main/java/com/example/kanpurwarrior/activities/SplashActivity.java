package com.example.kanpurwarrior.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kanpurwarrior.MainActivity;
import com.example.kanpurwarrior.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    private Animation topAnim,bottomAnim;
    private ImageView logoIv;
    private TextView logoTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.splash_top_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.splash_bottom_anim);

        logoIv=findViewById(R.id.logoIv);
        logoTv=findViewById(R.id.logoTv);
        logoTv.setAnimation(bottomAnim);
        logoIv.setAnimation(topAnim);

        //###### Following code is added by me
        //Glide.with(getApplicationContext()).load("https://pixy.org/src/477/4774988.jpg").into(logoIv);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //todo: check whether the user was already logged in or not
                FirebaseAuth auth=FirebaseAuth.getInstance();
                if(auth.getCurrentUser()==null){
                    Intent mainIntent=new Intent(SplashActivity.this,AuthenticationActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
                else{
                    Intent mainIntent=new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
        },2000);
    }
}