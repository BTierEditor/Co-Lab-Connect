package com.example.co_labconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chat extends AppCompatActivity {
    AppCompatImageButton addimagebtn,sendmsgbtn;
    AppCompatEditText addmessage;
    RecyclerView usermsg;
    DatabaseReference roofref;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        roofref = FirebaseDatabase.getInstance().getReference();

        sendmsgbtn = (AppCompatImageButton) findViewById(R.id.send_message_out);
        addimagebtn = (AppCompatImageButton) findViewById(R.id.send_image_out);
        addmessage = (AppCompatEditText) findViewById(R.id.add_msg);

        //-----------------------------------------STRING-----------------------------------------//

        //-----------------------------------------STRING-----------------------------------------//

        sendmsgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(addmessage.getText().toString().isEmpty()){
                    Toast.makeText(Chat.this, "Cannot send empty message", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Chat.this, ""+addmessage.getText().toString(), Toast.LENGTH_SHORT).show();
                    addmessage.setText("");

                }
            }
        });


    }
}