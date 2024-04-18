package com.example.co_labconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.co_labconnect.chat.ChatAdapter;
import com.example.co_labconnect.chat.ChatModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Chatroom extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String MSG;
    TextView namereplace;
    EditText msg_space;
    ImageButton back_btn;
    ImageButton send_btn;
    RecyclerView recyclerView;
    FirebaseAuth mAuth;
    String uid;
    String message;
    ArrayList<ChatModel> chat = new ArrayList<>();
    CollectionReference chatCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        namereplace = findViewById(R.id.User_name);
        back_btn = findViewById(R.id.back_btn);
        send_btn = findViewById(R.id.send_btn);
        msg_space = findViewById(R.id.msg_space);
        recyclerView = findViewById(R.id.recycler_view_chat);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        mAuth = FirebaseAuth.getInstance();
        uid = mAuth.getCurrentUser().getUid();
        chatCollection = db.collection("chatroom");

        send_btn.setOnClickListener((v -> {
            String message = msg_space.getText().toString().trim();
            if (message.isEmpty()) {
                Toast.makeText(this, "Please Enter a message", Toast.LENGTH_SHORT).show();
            } else {
                // Generate a unique ChatRoomID
                String chatRoomId = chatCollection.document().getId();

                HashMap<String, Object> chatmap = new HashMap<>();
                chatmap.put("Uid", uid);
                chatmap.put("message", message);
                chatmap.put("ChatRoomID", chatRoomId);

                chatCollection.document(chatRoomId).set(chatmap)
                        .addOnSuccessListener(aVoid -> {
                            // Clear message input after sending
                            msg_space.setText("");
                            Toast.makeText(Chatroom.this, "Message Sent", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e ->
                                Toast.makeText(Chatroom.this, "Failed to send message: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        }));

        chatCollection.addSnapshotListener((snapshot, e) -> {
            if (e != null) {
                // Handle error
                return;
            }

            if (snapshot != null) {
                chat.clear();
                for (DocumentSnapshot document : snapshot.getDocuments()) {
                    String message = document.getString("message");
                    if (message != null) {
                        ChatModel chatModel = new ChatModel(message);
                        chat.add(chatModel);
                    }
                }

                ChatAdapter chatAdapter = new ChatAdapter(getApplicationContext(), chat);
                recyclerView.setAdapter(chatAdapter);
            }
        });

        String nameget = getIntent().getStringExtra("namein");
        namereplace.setText(nameget);

        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ChatHall.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ChatHall.class);
        startActivity(intent);
        finish();
    }
}
