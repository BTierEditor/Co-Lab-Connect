package com.example.co_labconnect;

import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatHall extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth mAuth;
    RecyclerView recyclerView;
    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn;

    LottieAnimationView animationView;
    Chat_RecyclerView_Adapter adapter;
    String Uid,currentuserid;
    DatabaseReference reference,userref;
    ArrayList<Chat_Recyler_ModelClass> arrayList = new ArrayList<>();

    ImageButton backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_hall);

        settingbtn = findViewById(R.id.navigation_setting);
        profilebtn = findViewById(R.id.navigation_profile);
        chatbtn = findViewById(R.id.navigation_chat);
        homebtn = findViewById(R.id.navigation_home);

        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        user = mAuth.getCurrentUser();
        
        animationView = findViewById(R.id.loading_chat);
        recyclerView = findViewById(R.id.recyclerView);
        backbtn = findViewById(R.id.chat_backbtn);


        backbtn.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),HomePage.class);
            startActivity(i);
            finish();
        });

        adapter = new Chat_RecyclerView_Adapter(arrayList, new Chat_RecyclerView_Adapter.Chat_RecylerView_Clicked() {
            @Override
            public void ItemClicked(String name, int position) {
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),Chatroom.class);
                i.putExtra("namein",name);
                startActivity(i);
                finish();

            }
        });
        mAuth = FirebaseAuth.getInstance();
        recyclerView.setAdapter(adapter);
//        user.getUid().toString();
        reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    animationView.setVisibility(View.GONE);
                    if(snapshot.child("Name").getValue().toString().equals(HomePage.USERNAME)){
                        Chat_Recyler_ModelClass chatRecylerModelClass = new Chat_Recyler_ModelClass(HomePage.USERNAME+" (You)");
                        arrayList.add(chatRecylerModelClass);
                    }
                    else {
                        Chat_Recyler_ModelClass chatRecylerModelClass = new Chat_Recyler_ModelClass(snapshot.child("Name").getValue().toString());
                        arrayList.add(chatRecylerModelClass);
                    }
//                    String names = snapshot.child("Name").getValue().toString();
//
//                    Toast.makeText(getApplicationContext(), names, Toast.LENGTH_SHORT).show();
                }
//                replace.setText(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
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
                profilebtn.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(),user_profile.class);
                startActivity(intent);
                homebtn.setVisibility(View.VISIBLE);
                chatbtn.setVisibility(View.VISIBLE);
                settingbtn.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}