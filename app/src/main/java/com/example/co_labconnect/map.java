package com.example.co_labconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class map extends AppCompatActivity {

    RelativeLayout click_213,click_214,click_215,click_dowm,click_up,click_216,click_207,click_201;
    CardView card_214,card_213,card_215,card_216,card_207,card_201;
    CardView box;
    AppCompatButton navigation,image;
    AppCompatImageButton card_214_closing,card_213_closing,card_215_closing,card_216_closing,card_207_closing,card_201_closing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        click_213 = findViewById(R.id.click_213);
        card_213 = findViewById(R.id.card_213);
        card_213_closing = findViewById(R.id.card_213_closeing);

        click_214 = findViewById(R.id.click_214);
        card_214 = findViewById(R.id.card_214);
        card_214_closing = findViewById(R.id.card_214_closeing);

        click_215 = findViewById(R.id.click_215);
        card_215 = findViewById(R.id.card_215);
        card_215_closing = findViewById(R.id.card_215_closeing);

        click_dowm = findViewById(R.id.click_down);
        click_up = findViewById(R.id.click_up);

        click_216 = findViewById(R.id.click_216);
        card_216 = findViewById(R.id.card_216);
        card_216_closing = findViewById(R.id.card_216_closeing);

        click_207 = findViewById(R.id.click_207);
        card_207 = findViewById(R.id.card_207);
        card_207_closing = findViewById(R.id.card_207_closeing);

        click_201 = findViewById(R.id.click_201);
        card_201 = findViewById(R.id.card_201);
        card_201_closing = findViewById(R.id.card_201_closeing);

        navigation = findViewById(R.id.navigation_click);
        image = findViewById(R.id.image_click);

        box = findViewById(R.id.box_card);

//-=========================================213-=================================================//
        click_213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);
                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_213.setVisibility(View.VISIBLE);
                        card_213.setAnimation(animSlide);
                        card_213.startAnimation(animSlide);

                        card_213_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_213.setAnimation(animSlideout);
                                card_213.startAnimation(animSlideout);
                                card_213.setVisibility(View.GONE);
                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);


                            }
                        });
                    }
                });
            }
        });
//-=========================================214-=================================================//
        click_214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);

                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_214.setVisibility(View.VISIBLE);
                        card_214.setAnimation(animSlide);
                        card_214.startAnimation(animSlide);

                        card_214_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_214.setAnimation(animSlideout);
                                card_214.startAnimation(animSlideout);
                                card_214.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);

                            }
                        });
                    }
                });
            }
        });
//-=========================================215-=================================================//
        click_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);

                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);


                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_215.setVisibility(View.VISIBLE);
                        card_215.setAnimation(animSlide);
                        card_215.startAnimation(animSlide);

                        card_215_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_215.setAnimation(animSlideout);
                                card_215.startAnimation(animSlideout);
                                card_215.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);

                            }
                        });
                    }
                });
            }
        });
//-=========================================216-=================================================//
        click_216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);

                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_216.setVisibility(View.VISIBLE);
                        card_216.setAnimation(animSlide);
                        card_216.startAnimation(animSlide);
                        card_216_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_216.setAnimation(animSlideout);
                                card_216.startAnimation(animSlideout);
                                card_216.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                            }
                        });
                    }
                });
            }
        });
//-=========================================Go Down-=================================================//
        click_dowm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(map.this, "1st Floor map under construction", Toast.LENGTH_SHORT).show();
            }
        });
//-=========================================Go Up-=================================================//
        click_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(map.this, "3rd Floor map under construction", Toast.LENGTH_SHORT).show();
            }
        });
//-=========================================207-=================================================//
        click_207.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);

                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_207.setVisibility(View.VISIBLE);
                        card_207.setAnimation(animSlide);
                        card_207.startAnimation(animSlide);
                        card_207_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_207.setAnimation(animSlideout);
                                card_207.startAnimation(animSlideout);
                                card_207.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                            }
                        });
                    }
                });
            }
        });
//-=========================================201-=================================================//
        click_201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);

                click_213.setClickable(false);
                click_214.setClickable(false);
                click_215.setClickable(false);
                click_dowm.setClickable(false);
                click_up.setClickable(false);
                click_216.setClickable(false);
                click_207.setClickable(false);
                click_201.setClickable(false);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_201.setVisibility(View.VISIBLE);
                        card_201.setAnimation(animSlide);
                        card_201.startAnimation(animSlide);

                        card_201_closing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_201.setAnimation(animSlideout);
                                card_201.startAnimation(animSlideout);
                                card_201.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                            }
                        });
                    }
                });
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}