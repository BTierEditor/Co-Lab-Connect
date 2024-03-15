
package com.example.co_labconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class user_profile extends AppCompatActivity {
    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn;
    Button edit_profile_button;

    TextView emailshow,nameshow,ageshow,enrollshow,classshow,numbershow;
    FirebaseUser user;
    FirebaseAuth mAuth;
    DatabaseReference userref;
    String currentuserid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        user = mAuth.getCurrentUser();

        numbershow = findViewById(R.id.number_showcase);
        classshow = findViewById(R.id.class_showcase);
        enrollshow = findViewById(R.id.enroll_showcase);
        ageshow = findViewById(R.id.age_showcase);
        nameshow = findViewById(R.id.name_showcase);
        emailshow = findViewById(R.id.wmail_showcase);
        settingbtn = findViewById(R.id.navigation_setting);
        profilebtn = findViewById(R.id.navigation_profile);
        chatbtn = findViewById(R.id.navigation_chat);
        homebtn = findViewById(R.id.navigation_home);
        edit_profile_button = findViewById(R.id.edit_profile_button);

        edit_profile_button.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(), Profile.class);
           startActivity(intent);
           finish();
        });

        userref.child(currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
               if(datasnapshot.exists()){
                   String namefromdatabase = datasnapshot.child("Name").getValue().toString();
                   nameshow.setText(namefromdatabase);

                   String agefromdatabase = datasnapshot.child("Age").getValue().toString();
                   ageshow.setText(agefromdatabase);

                   String enrollfromdatabase = datasnapshot.child("Enrollment").getValue().toString();
                   enrollshow.setText(enrollfromdatabase);

                   String classfromdatabase = datasnapshot.child("Class").getValue().toString();
                   classshow.setText(classfromdatabase);

                   String numberfromdatabase = datasnapshot.child("Number").getValue().toString();
                   numbershow.setText(numberfromdatabase);

               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        emailshow.setText(user.getEmail());

        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                settingbtn.setAnimation(animSlideout);
                settingbtn.startAnimation(animSlideout);
                settingbtn.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent);
                homebtn.setVisibility(View.VISIBLE);
                chatbtn.setVisibility(View.VISIBLE);
                profilebtn.setVisibility(View.VISIBLE);
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                profilebtn.setAnimation(animSlideout);
                profilebtn.startAnimation(animSlideout);

                Intent intent = new Intent(getApplicationContext(),user_profile.class);
                startActivity(intent);

                homebtn.setVisibility(View.VISIBLE);
                chatbtn.setVisibility(View.VISIBLE);
                settingbtn.setVisibility(View.VISIBLE);
            }
        });

        chatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                chatbtn.setAnimation(animSlideout);
                chatbtn.startAnimation(animSlideout);
                chatbtn.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(getApplicationContext(), ChatHall.class);
                startActivity(intent);

                homebtn.setVisibility(View.VISIBLE);
                profilebtn.setVisibility(View.VISIBLE);
                settingbtn.setVisibility(View.VISIBLE);

            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                homebtn.setAnimation(animSlideout);
                homebtn.startAnimation(animSlideout);
                homebtn.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(getApplicationContext(),HomePage.class);
                startActivity(intent);
                finish();

                chatbtn.setVisibility(View.VISIBLE);
                profilebtn.setVisibility(View.VISIBLE);
                settingbtn.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}