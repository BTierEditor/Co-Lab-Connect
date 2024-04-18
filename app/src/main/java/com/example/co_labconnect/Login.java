package com.example.co_labconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    //-------------------------------------------declare--------------------------------------------//
    Button lgnbtn;
   public static String name;
    String currentuserid;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;

    TextInputEditText emailenter,passwordenter;
    TextView regbtn,forgot_password_btn;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    LottieAnimationView loading;





    @Override
    public void onStart() {
        sharedPreferences = getSharedPreferences("userLoggedIn", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();


        if (sharedPreferences.getBoolean("login", false)) {

        }
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            name = currentUser.getUid();
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Handler handler = new Handler();
//        DatabaseReference dlt_data = FirebaseDatabase.getInstance().getReference().child("Posts");
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                dlt_data.setValue(null);
//                handler.postDelayed(this, 60000); // 24
//            }
//        };
//        handler.post(runnable);

        mAuth = FirebaseAuth.getInstance();

        loading = findViewById(R.id.loading);
        emailenter = findViewById(R.id.username_input);
        passwordenter = findViewById(R.id.password_input);
        regbtn= findViewById(R.id.Registerhere);
        lgnbtn=findViewById(R.id.login_button);
        forgot_password_btn = findViewById(R.id.forgot_password_btn);

        //-===============================================================================//



        forgot_password_btn.setOnClickListener(v -> {
            FirebaseAuth auth = FirebaseAuth.getInstance();

            String emailAddress = emailenter.getText().toString();

            if(TextUtils.isEmpty(emailAddress)){
                Toast.makeText(getApplicationContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                return;
            }

            auth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Email has been sent!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(this, "Email Not Found", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        //-===============================================================================//

        lgnbtn.setOnClickListener(view -> {

            loading.setVisibility(View.VISIBLE);
            String email,password;
            email = String.valueOf(emailenter.getText());
            password = String.valueOf(passwordenter.getText());

            if(TextUtils.isEmpty(email)){
                Toast.makeText(getApplicationContext(), "Please enter Username", Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                loading.setVisibility(View.GONE);
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                loading.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),HomePage.class);
                                startActivity(intent);
                                finish();
                                currentuserid = mAuth.getCurrentUser().getUid();
                                getName();
                                sharedPreferencesEditor.putBoolean("login", true);
                                sharedPreferencesEditor.putBoolean("login", true);
                                sharedPreferencesEditor.putString("Name", name);
                                sharedPreferencesEditor.commit();
                            } else {
                                loading.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Invaild Email or Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });

        regbtn.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this,Register.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(Login.this);
        alert.setTitle("Exit?");
        alert.setMessage("Do you want to exit Co-Lab Connect?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.show();
    }

    public  void getName(){



        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(currentuserid);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name = snapshot.child("Name").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}