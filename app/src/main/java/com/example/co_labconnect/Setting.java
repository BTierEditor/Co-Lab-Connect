package com.example.co_labconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Setting extends AppCompatActivity {

    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn;
    Button logout,delete_account_button,delete_tweets_button;
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
        delete_account_button = findViewById(R.id.delete_account_button);
        delete_tweets_button = findViewById(R.id.delete_tweets_button);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        
        logout.setOnClickListener(view -> {
            logout_dilog();
        });
        delete_account_button.setOnClickListener(v -> {
            AlertDialog.Builder delete_user_alert = new AlertDialog.Builder(Setting.this);
            delete_user_alert.setTitle("DELETE YOUR ACCOUNT?");
            delete_user_alert.setMessage("Are you sure you want to delete your account?");
            delete_user_alert.setPositiveButton("Yes", (dialog, which) -> {delete_account();});
            delete_user_alert.setNegativeButton("No", (dialog, which) -> {dialog.dismiss();});
            delete_user_alert.show();
        });

        delete_tweets_button.setOnClickListener(v -> {
            
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

    //-------------------------VOIDS-----------------------------//
    private void delete_account() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Setting.this, "Good Luck :)", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Setting.this,Login.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }
    private void logout_dilog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(Setting.this);
        alert.setTitle("Logout?");
        alert.setMessage("Do you want to Logout of Co-Lab Connect?");
        alert.setPositiveButton("yes", (dialog, which) -> { signout(); });
        alert.setNegativeButton("No", (dialog, which) -> { dialog.dismiss(); });
        alert.show();
    }


    private void signout() {
        Toast.makeText(getApplicationContext(), "See you soon!", Toast.LENGTH_SHORT).show();
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertout = new AlertDialog.Builder(Setting.this);
        alertout.setTitle("Exit?");
        alertout.setMessage("Do you want to Exit Co-Lab Connect?");
        alertout.setPositiveButton("yes", (dialog, which) -> { finishAffinity(); });
        alertout.setNegativeButton("No", (dialog, which) -> { dialog.dismiss(); });
        alertout.show();
    }
}