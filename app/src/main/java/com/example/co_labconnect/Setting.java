package com.example.co_labconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Setting extends AppCompatActivity {

    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn;
    Button logout;
    FirebaseUser user;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingbtn = findViewById(R.id.navigation_setting);
        profilebtn = findViewById(R.id.navigation_profile);
        chatbtn = findViewById(R.id.navigation_chat);
        homebtn = findViewById(R.id.navigation_home);
        logout=findViewById(R.id.logout_button);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "See you soon!", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                profilebtn.setAnimation(animSlideout);
                profilebtn.startAnimation(animSlideout);
                profilebtn.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(),user_profile.class);
                startActivity(intent);
                homebtn.setVisibility(View.VISIBLE);
                chatbtn.setVisibility(View.VISIBLE);
                settingbtn.setVisibility(View.VISIBLE);
            }
        });

        chatbtn.setOnClickListener(view -> {
            Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
            chatbtn.setAnimation(animSlideout);
            chatbtn.startAnimation(animSlideout);
            chatbtn.setVisibility(View.VISIBLE);
            Intent intent = new Intent(getApplicationContext(), ChatHall.class);
            startActivity(intent);
            homebtn.setVisibility(View.INVISIBLE);
            profilebtn.setVisibility(View.VISIBLE);
            settingbtn.setVisibility(View.VISIBLE);
        });
        homebtn.setOnClickListener(view -> {
            Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
            homebtn.setAnimation(animSlideout);
            homebtn.startAnimation(animSlideout);
            homebtn.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            startActivity(intent);
            chatbtn.setVisibility(View.VISIBLE);
            profilebtn.setVisibility(View.VISIBLE);
            settingbtn.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void onBackPressed() {

    }
}