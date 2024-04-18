
package com.example.co_labconnect;

import static java.security.AccessController.getContext;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_profile extends AppCompatActivity {
    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn;
    Button edit_profile_button;

    TextView emailshow,nameshow,ageshow,enrollshow,classshow,numbershow;
    FirebaseUser user;
    FirebaseAuth mAuth;
    DatabaseReference userref;
    ActivityResultLauncher<Intent> imagePickLauncher;
    String currentuserid;
    StorageReference storageReference;
    Uri selectedImageUri;
    CircleImageView profile_image;
    LottieAnimationView loading,name_loading,age_loading,enroll_loading,class_loading,phone_loading;
    CardView profile_card;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        user = mAuth.getCurrentUser();
        String uid = currentuserid+(".jpg");
        storageReference = FirebaseStorage.getInstance().getReference("profiles").child(uid);

        try {
            File file = File.createTempFile("tempfile",".jpg");
            storageReference.getFile(file).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    profile_image.setImageBitmap(bitmap);
                    loading.setVisibility(View.GONE);
                    profile_card.setVisibility(View.VISIBLE);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
        profile_image = findViewById(R.id.profile_image);
        profile_card = findViewById(R.id.profile_card);

        loading = findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);

        name_loading = findViewById(R.id.name_loading);
        name_loading.setVisibility(View.VISIBLE);

        age_loading = findViewById(R.id.age_loading);
        age_loading.setVisibility(View.VISIBLE);

        enroll_loading = findViewById(R.id.enroll_loading);
        enroll_loading.setVisibility(View.VISIBLE);

        class_loading = findViewById(R.id.class_loading);
        class_loading.setVisibility(View.VISIBLE);

        phone_loading = findViewById(R.id.class_loading);
        phone_loading.setVisibility(View.VISIBLE);

        edit_profile_button.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(), Profile.class);
           startActivity(intent);
           finish();
        });
        profilebtn.setClickable(false);
        userref.child(currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
               if(datasnapshot.exists()){
                   String namefromdatabase = datasnapshot.child("Name").getValue().toString();
                   nameshow.setText(namefromdatabase);
                   name_loading.setVisibility(View.GONE);
                   nameshow.setVisibility(View.VISIBLE);

                   String agefromdatabase = datasnapshot.child("Age").getValue().toString();
                   ageshow.setText(agefromdatabase);
                   age_loading.setVisibility(View.GONE);
                   ageshow.setVisibility(View.VISIBLE);

                   String enrollfromdatabase = datasnapshot.child("Enrollment").getValue().toString();
                   enrollshow.setText(enrollfromdatabase);
                   enroll_loading.setVisibility(View.GONE);
                   enrollshow.setVisibility(View.VISIBLE);

                   String classfromdatabase = datasnapshot.child("Class").getValue().toString();
                   classshow.setText(classfromdatabase);
                   class_loading.setVisibility(View.GONE);
                   classshow.setVisibility(View.VISIBLE);

                   String numberfromdatabase = datasnapshot.child("Number").getValue().toString();
                   numbershow.setText(numberfromdatabase);
                   phone_loading.setVisibility(View.GONE);
                   numbershow.setVisibility(View.VISIBLE);

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

//        profilebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
//                profilebtn.setAnimation(animSlideout);
//                profilebtn.startAnimation(animSlideout);
//                profilebtn.setClickable(false);
//
//                Intent intent = new Intent(getApplicationContext(),user_profile.class);
//                startActivity(intent);
//
//                homebtn.setVisibility(View.VISIBLE);
//                chatbtn.setVisibility(View.VISIBLE);
//                settingbtn.setVisibility(View.VISIBLE);
//            }
//        });

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
        AlertDialog.Builder alertout = new AlertDialog.Builder(user_profile.this);
        alertout.setTitle("Exit?");
        alertout.setMessage("Do you want to Exit Co-Lab Connect?");
        alertout.setPositiveButton("yes", (dialog, which) -> { finishAffinity(); });
        alertout.setNegativeButton("No", (dialog, which) -> { dialog.dismiss(); });
        alertout.show();
    }
}