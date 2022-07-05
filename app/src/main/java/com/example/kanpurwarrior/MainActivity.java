package com.example.kanpurwarrior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kanpurwarrior.activities.AuthenticationActivity;
import com.example.kanpurwarrior.fragments.HomeFragment;
import com.example.kanpurwarrior.fragments.MyAccountFragment;
import com.example.kanpurwarrior.fragments.MyCoursesFragment;
import com.example.kanpurwarrior.fragments.MyNotesFragment;
import com.example.kanpurwarrior.fragments.MyTestsFragment;
import com.example.kanpurwarrior.fragments.NotificationFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private TextView titleTv;
    private FirebaseAuth auth;
    private FrameLayout parentFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.mainDrawerLayout);
        toolbar=findViewById(R.id.activity_main_toolbar);
        auth=FirebaseAuth.getInstance();
        titleTv=findViewById(R.id.titleTvMain);
        parentFrameLayout=findViewById(R.id.main_activity_frameLayout);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        setFragment(new HomeFragment());//by default HomeFragment khula rahe na ki acivity_main.xml ka layout show ho

        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            MenuItem menuItem;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuItem=item;

                drawerLayout.closeDrawer(GravityCompat.START);
                drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);

                        switch(menuItem.getItemId())
                        {
                            case R.id.nav_home:
                                gotoFragment(new HomeFragment(),"Kanpur Warrior");
                                break;
                            case R.id.nav_myCourses:
                                gotoFragment(new MyCoursesFragment(),"My Courses");
                                break;
                            case R.id.nav_mynotes:
                                gotoFragment(new MyNotesFragment(),"My Notes");
                                break;
                            case R.id.nav_mytests:
                                gotoFragment(new MyTestsFragment(),"My Tests");
                                break;
                            case R.id.nav_notification:
                                gotoFragment(new NotificationFragment(),"Notifications");
                                break;
                            case R.id.nav_myaccount:
                                gotoFragment(new MyAccountFragment(),"My Account");
                                break;


                            case R.id.nav_share:
                                Intent sendIntent=new Intent();
                                sendIntent.setAction(Intent.ACTION_SEND);
                                sendIntent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out this trending App Kanpur Warrior.\nHave a Good Day.");
                                sendIntent.setType("text/plain");
                                startActivity(sendIntent);
                                break;

                            case R.id.nav_help:
                                Intent intent=new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:1234567890"));
                                startActivity(intent);
                                break;
                                
                            case R.id.nav_youtube:
                                Intent intent1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCBqIja2tCHX669FBd2NQBig"));
                                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent1.setPackage("com.google.android.youtube");
                                startActivity(intent1);
                                break;
                            case R.id.nav_telegram:
                                Toast.makeText(MainActivity.this, "We are launching a Telegram\nChannel soon. Thanks for checking us out.", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.nav_about:
                                Toast.makeText(MainActivity.this, "App Developed by Vibhu Pandey @Joaquin144.", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.nav_logout:
                                ////////Toast.makeText(MainActivity.this, "Kahan chale Aap?", Toast.LENGTH_SHORT).show();
                                auth.signOut();
                                Intent intentSignOut=new Intent(MainActivity.this, AuthenticationActivity.class);
                                startActivity(intentSignOut);
                                finish();

                        }
                    }
                });
                return true;
            }
        });

    }

    protected void gotoFragment(Fragment fragment,String title){
        setFragment(fragment);
        titleTv.setText(title);
    }
    protected void setFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        transaction.replace(parentFrameLayout.getId(),fragment);
        transaction.commit();
    }

    //If we want to show custom menu on top of our Action Bar then we need to override the following function in our Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_action_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}