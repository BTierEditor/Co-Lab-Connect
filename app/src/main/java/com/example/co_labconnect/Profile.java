package com.example.co_labconnect;

import static java.security.AccessController.getContext;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.co_labconnect.Utils.AndroidUtil;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.StartupTime;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Profile extends AppCompatActivity {

    Button proceedebtn;
    CheckBox tandc;
    EditText setup_name,setup_age,setup_enroll,setup_class,setup_number;
    FirebaseAuth mAuth;
    DatabaseReference userref;
    String current_user;
    FirebaseUser user;
    StorageReference UserProfileImageRef;
    CircleImageView profilePic;
    String name,age,enroll,Class,number;
    DatabaseReference name_for_chat;
    ActivityResultLauncher<Intent> imagePickLauncher;
    Uri selectedImageUri;

    final static int galley_picker = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        current_user = mAuth.getCurrentUser().getUid();

        userref = FirebaseDatabase.getInstance().getReference().child("Users").child(current_user);
        name_for_chat = FirebaseDatabase.getInstance().getReference().child("Name_for_chat");


        UserProfileImageRef = FirebaseStorage.getInstance().getReference().child("profile images");


        proceedebtn = findViewById(R.id.proceede_button);
        setup_number = findViewById(R.id.setup_number);
        setup_name = findViewById(R.id.setup_name);
        setup_age = findViewById(R.id.setup_age);
        setup_enroll = findViewById(R.id.setup_Enrollmentno);
        setup_class = findViewById(R.id.setup_class);
        tandc = findViewById(R.id.terms_and_conditions);
        profilePic = findViewById(R.id.profile_image_view);




        profilePic.setOnClickListener(v -> {

            ImagePicker.with(Profile.this).cropSquare().compress(512).maxResultSize(512,512)
                    .createIntent(new Function1<Intent, Unit>() {
                        @Override
                        public Unit invoke(Intent intent) {
                            imagePickLauncher.launch(intent);
                            return null;
                        }
                    });
        });

        imagePickLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        if(data!=null && data.getData()!=null){
                            selectedImageUri = data.getData();
//                            AndroidUtil.setProfilePic(getContext(),selectedImageUri,profilePic);
                            profilePic.setImageURI(selectedImageUri);
                        }
                    }
                }
        );
        proceedebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = setup_name.getText().toString();
                age = setup_age.getText().toString();
                enroll = setup_enroll.getText().toString();
                Class = setup_class.getText().toString();
                number = setup_number.getText().toString();

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(Profile.this, "Please Enter name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(age)) {
                    Toast.makeText(Profile.this, "Please Enter age", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(enroll)) {
                    Toast.makeText(Profile.this, "Please Enter Enrollment Number", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(Class)) {
                    Toast.makeText(Profile.this, "Please Enter Class eg.TyCo1", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(number)) {
                    Toast.makeText(Profile.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if(tandc.isChecked()){
                    Intent intent = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(intent);
                    finish();



                    HashMap usermap = new HashMap();
                    usermap.put("Name",name);
                    usermap.put("Age",age);
                    usermap.put("Enrollment",enroll);
                    usermap.put("Class",Class);
                    usermap.put("Number",number);

                    HashMap chat_names = new HashMap();
                    chat_names.put("Name",name);

                    name_for_chat.updateChildren(chat_names).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isComplete()){
                                Toast.makeText(Profile.this, "Complete", Toast.LENGTH_SHORT).show();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(Profile.this, "An Error Occured:"+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    userref.updateChildren(usermap).addOnCompleteListener(new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if(task.isComplete()){
                                Toast.makeText(Profile.this, "Complete", Toast.LENGTH_SHORT).show();
                            }else{
                                String error = task.getException().getMessage();
                                Toast.makeText(Profile.this, "An Error Occured:"+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Toast.makeText(Profile.this, "Welcome to Co-Lab Connect "+name, Toast.LENGTH_SHORT).show();
                    Toast.makeText(Profile.this, "Check out some feeds!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Profile.this, "Please Read Terms and Conditions", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),user_profile.class);
        startActivity(intent);
        finish();
    }

}