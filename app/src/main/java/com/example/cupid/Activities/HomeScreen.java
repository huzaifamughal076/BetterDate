package com.example.cupid.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cupid.Fragments.DiscoverFragment;
import com.example.cupid.Fragments.LikesFragment;
import com.example.cupid.Fragments.MessagesFragment;
import com.example.cupid.Fragments.ProfileFragment;
import com.example.cupid.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frame;

    DiscoverFragment discoverFragment;
    MessagesFragment messagesFragment;
    ProfileFragment profileFragment;

    LikesFragment likesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        frame = findViewById(R.id.frame);

        discoverFragment=new DiscoverFragment();
        messagesFragment=new MessagesFragment();
        profileFragment=new ProfileFragment();

        likesFragment = new LikesFragment();

        setfragment(discoverFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.discover:
                        setfragment(discoverFragment);
                        return true;
                    case R.id.likes:
                        //Intent i = new Intent(getApplicationContext(),LikesActivity.class);
                      //  startActivity(i);
                        setfragment(likesFragment);
                        return true;
                    case R.id.messages:
                        setfragment(messagesFragment);
                        return true;
                    case R.id.profile:
                        setfragment(profileFragment);
                        return true;
                    default:
                        return false;
                }

            }

        });

        }
    private void setfragment(Fragment page) {

        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,page);
        fragmentTransaction.commit();

    }
}