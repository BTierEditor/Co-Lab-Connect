package com.example.co_labconnect;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class password_reset_activity extends AppCompatActivity {

    AppCompatEditText emailin;

    Button send_mail_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_reset);

        emailin = findViewById(R.id.emailin);
        send_mail_btn = findViewById(R.id. send_mail_btn);
        FirebaseAuth auth = FirebaseAuth.getInstance();



        send_mail_btn.setOnClickListener(v -> {
            String email = emailin.getText().toString();

            if(TextUtils.isEmpty(email)){
                Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
            }

            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(password_reset_activity.this, "Email has been sent!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "Email Not Found", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}