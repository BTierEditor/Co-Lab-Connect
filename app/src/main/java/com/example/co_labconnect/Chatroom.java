package com.example.co_labconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Chatroom extends AppCompatActivity {

    String MSG;
    TextView namereplace;
    EditText msg_space;
    ImageButton back_btn;
    ImageButton send_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        namereplace = findViewById(R.id.User_name);
        back_btn = findViewById(R.id.back_btn);
        send_btn = findViewById(R.id.send_btn);
        msg_space = findViewById(R.id.msg_space);
        String nameget = getIntent().getStringExtra("namein");
        namereplace.setText(nameget);

        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ChatHall.class);
            startActivity(intent);
            finish();
        });

        send_btn.setOnClickListener(view -> {
            MSG = msg_space.getText().toString();
            msg_space.setText("");
            Toast.makeText(this, ""+MSG, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),ChatHall.class);
        startActivity(intent);
        finish();
    }
}