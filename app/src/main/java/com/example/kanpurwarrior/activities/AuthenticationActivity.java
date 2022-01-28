package com.example.kanpurwarrior.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.example.kanpurwarrior.R;
import com.example.kanpurwarrior.fragments.LogInFragment;

public class AuthenticationActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    public static boolean isLoginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        frameLayout=findViewById(R.id.frameLayoutAuth);
        setDefaultFragment(new LogInFragment());
        isLoginFragment=true;
    }

    private void setDefaultFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(isLoginFragment)
                finish();
            else
            {
                isLoginFragment=true;changeFragment(new LogInFragment());
            }

        }
        //return super.onKeyDown(keyCode, event);
        return false;
    }

    private void changeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}