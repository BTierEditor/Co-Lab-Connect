package com.example.co_labconnect;

import static android.app.ProgressDialog.show;
import static androidx.recyclerview.widget.LinearLayoutManager.*;
import static com.example.co_labconnect.Login.sharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.co_labconnect.HomePageRecycler.Tweet_Recycler_Adapter;
import com.example.co_labconnect.HomePageRecycler.Tweet_Recycler_ModelClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePage extends AppCompatActivity {

    Toolbar toolbarobj;
    public static String USERNAME;
    FloatingActionButton addbtn;
    int i=0;
    RelativeLayout post;
    ImageView post_back_btn;
    LottieAnimationView loading;
    EditText thoughtsin;
    Tweet_Recycler_Adapter adapter;

    CoordinatorLayout navigationlay;
    Button post_button;
    TextView replace1;
    TextView tweetuseridshow,tweetuseremailshow,textView;
    AppCompatImageButton homebtn,chatbtn,profilebtn,settingbtn,mapbtn;

    FirebaseUser user;
    FirebaseAuth mAuth;
    DatabaseReference userref,postref;
    StorageReference storageReference;
    String currentuserid;
    String savecurrenttime,savecurrentdate,postrandomname;
    String namefromdatabase;
    CircleImageView homepage_bg;
    RecyclerView recyclerView;
    ArrayList<Tweet_Recycler_ModelClass>  arrayList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        USERNAME =  sharedPreferences.getString("Name", "");
        recyclerView=findViewById(R.id.Tweet_recycler);
        adapter = new Tweet_Recycler_Adapter(arrayList);
        recyclerView.setAdapter(adapter);

        mAuth = FirebaseAuth.getInstance();
        currentuserid = mAuth.getCurrentUser().getUid();
        userref = FirebaseDatabase.getInstance().getReference().child("Users");
        postref = FirebaseDatabase.getInstance().getReference().child("Posts").child(currentuserid);
        user = mAuth.getCurrentUser();
        String uid = currentuserid+(".jpg");
        storageReference = FirebaseStorage.getInstance().getReference("profiles").child(uid);
        //-====================== test code-===============================//

        try {
            File file = File.createTempFile("tempfile",".jpg");
            storageReference.getFile(file).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    homepage_bg.setImageBitmap(bitmap);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //-====================== test code-===============================//

        getData();

        mapbtn = findViewById(R.id.map_button);
        tweetuseremailshow = findViewById(R.id.tweet_email_showcase);
        tweetuseridshow = findViewById(R.id.tweet_name_showcase);
        settingbtn = findViewById(R.id.navigation_setting);
        profilebtn = findViewById(R.id.navigation_profile);
        chatbtn = findViewById(R.id.navigation_chat);
        homebtn = findViewById(R.id.navigation_home);
        toolbarobj = findViewById(R.id.toolbar);
        addbtn = findViewById(R.id.addingbutton);
        post = findViewById(R.id.post_btn);
        post_back_btn = findViewById(R.id.post_back_button);
        thoughtsin=findViewById(R.id.Thoughtsin);
        navigationlay=findViewById(R.id.navigationlayout);
        post_button=findViewById(R.id.thoughtspostbtn);
        replace1=findViewById(R.id.replace1);
        textView = findViewById(R.id.User_name);
        homepage_bg = findViewById(R.id.homepage_bg);
        loading = findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);


//        tweetuseremailshow.setText(user.getEmail());

        userref.child(currentuserid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if(datasnapshot.exists()){
                    namefromdatabase = datasnapshot.child("Name").getValue().toString();
                    tweetuseridshow.setText(namefromdatabase);
                    textView.setText(namefromdatabase);
                    loading.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
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

        chatbtn.setOnClickListener(view -> {

                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_up);
                chatbtn.setAnimation(animSlideout);
                chatbtn.startAnimation(animSlideout);
                chatbtn.setVisibility(View.VISIBLE);
            Intent intent = new Intent(getApplicationContext(), ChatHall.class);
            startActivity(intent);

            profilebtn.setVisibility(View.VISIBLE);
            settingbtn.setVisibility(View.VISIBLE);

        });
        homebtn.setClickable(false);

        
        mapbtn.setOnClickListener(view -> {
            Toast.makeText(HomePage.this, "Welcome to JMap Beta "+namefromdatabase, Toast.LENGTH_SHORT).show();
            Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/Jspm/@18.4722144,73.9369365,260m/data=!3m1!1e3!5m1!1e4?entry=ttu");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(mapIntent);
//            Intent intent = new Intent(getApplicationContext(), map.class);
//            startActivity(intent);
        });

        thoughtsin.setOnTouchListener((view, motionEvent) -> {
            navigationlay.setVisibility(View.INVISIBLE);
            return false;
        });

        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String thought;
                thought = thoughtsin.getText().toString();

                thoughtsin.getText().toString();
                if(thoughtsin.getText().toString().isEmpty()){
                    Toast.makeText(HomePage.this, "Cannot Tweet Blank", Toast.LENGTH_SHORT).show();
                }else{

                    Calendar CalForDate = Calendar.getInstance();
                    SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
                    savecurrentdate = currentdate.format(CalForDate.getTime());

                    Calendar CalFortime = Calendar.getInstance();
                    SimpleDateFormat currenttime = new SimpleDateFormat("HH:MM:ss");
                    savecurrenttime = currenttime.format(CalForDate.getTime());

                    postrandomname = savecurrentdate + " "+savecurrenttime;

                    String email = user.getEmail();
                    userref.child(currentuserid).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            HashMap postmap = new HashMap();
                            postmap.put("Thoughts",thought);
                            postmap.put("email",email);
                            postmap.put("name",namefromdatabase);
                            postmap.put("DateAndTime",postrandomname);

                            postref.child(postrandomname).updateChildren(postmap);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    replace1.setText(thoughtsin.getText().toString());
                    Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                    thoughtsin.setText("");
                    Toast.makeText(HomePage.this, "Tweeted successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i%2==0)
                {
                    Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out);
                    post.setAnimation(animSlideout);
                    post.startAnimation(animSlideout);
                    post.setVisibility(View.INVISIBLE);
                    addbtn.setImageResource(R.drawable.baseline_add_24);
                }
                else {
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                    post.setAnimation(anim);
                    post.startAnimation(anim);
                    post.setVisibility(View.VISIBLE);
                    addbtn.setImageResource(R.drawable.down_arrow);
                }

            }
        });

        post_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out);
                post.setAnimation(animSlideout);
                post.startAnimation(animSlideout);
                navigationlay.setVisibility(View.VISIBLE);
                post.setVisibility(View.INVISIBLE);
                addbtn.setImageResource(R.drawable.baseline_add_24);

            }
        });

    }
//-===============delete database-==========================//

//-===============delete database-==========================//

    @Override
    public void onBackPressed() {
        profilebtn.setVisibility(View.VISIBLE);
        navigationlay.setVisibility(View.VISIBLE);
        post.setVisibility(View.INVISIBLE);
        AlertDialog.Builder alert = new AlertDialog.Builder(HomePage.this);
        alert.setTitle("Exit?");
        alert.setMessage("Do you want to exit Co-Lab Connect?");
        alert.setPositiveButton("Yes", (dialogInterface, i) -> finishAffinity());
        alert.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss());
        alert.show();
    }

    void getData(){



        DatabaseReference  databaseReference = FirebaseDatabase.getInstance().getReference("Posts");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren()){

                for (DataSnapshot snapshot2: snapshot1.getChildren())
                {


                    Tweet_Recycler_ModelClass modelClass = new Tweet_Recycler_ModelClass(snapshot2.child("DateAndTime").getValue(String.class),snapshot2.child("name").getValue(String.class),snapshot2.child("Thoughts").getValue(String.class));
                    arrayList.add(modelClass);
                }
            }
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}