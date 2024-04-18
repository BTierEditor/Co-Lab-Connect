package com.example.co_labconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class map extends AppCompatActivity {

    RelativeLayout click_213,click_214,click_215,click_dowm,click_up,click_216,click_207,click_201,click_203,
            click_cc3,click_cc2,click_cc1,hallway;
    CardView card_214,card_213,card_215,card_216,card_207,card_201,card_203,card_cc3,card_cc2,card_cc1,navigation_pannel,card_hallway;
    CardView box;
    AppCompatButton navigation,image,start_journey_button;
    AppCompatImageButton card_214_closing,card_213_closing,card_215_closing,card_216_closing,card_hallway_closeing,
            card_207_closing,card_201_closing,card_203_closing,card_closing_cc3,card_closing_cc2,card_cc1_closeing;
    ImageView navigation_back_button,card_back_button;
    
    AppCompatEditText current_location,destination_location;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


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

        click_203 = findViewById(R.id.click_203);
        card_203 = findViewById(R.id.card_203);
        card_203_closing = findViewById(R.id.card_203_closeing);

        click_cc3 = findViewById(R.id.click_cc3);
        card_cc3 = findViewById(R.id.card_cc3);
        card_closing_cc3 = findViewById(R.id.card_cc3_closeing);

        click_cc2 = findViewById(R.id.click_cc2);
        card_cc2 = findViewById(R.id.card_cc2);
        card_closing_cc2 = findViewById(R.id.card_cc2_closeing);

        click_cc1 = findViewById(R.id.click_cc1);
        card_cc1 = findViewById(R.id.card_cc1);
        card_cc1_closeing = findViewById(R.id.card_cc1_closeing);

        hallway = findViewById(R.id.hallway);
        card_hallway_closeing = findViewById(R.id.card_hallway_closeing);
        card_hallway = findViewById(R.id.card_hallway);

        navigation = findViewById(R.id.navigation_click);
        navigation_pannel = findViewById(R.id.navigation_pannel);
        navigation_back_button = findViewById(R.id.navigation_back_button);

        card_back_button = findViewById(R.id.card_back_button);

        image = findViewById(R.id.image_click);

        start_journey_button = findViewById(R.id.start_journey_button);

        current_location = findViewById(R.id.current_location);
        destination_location = findViewById(R.id.destination_location);

        box = findViewById(R.id.box_card);

//-=========================================Hallway=================================================//
        
       hallway.setOnClickListener(v -> {
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
            click_cc3.setClickable(false);
            click_cc1.setClickable(false);
           hallway.setClickable(false);


            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                    box.setVisibility(View.GONE);
                    box.setAnimation(animSlideout);
                    box.startAnimation(animSlideout);

                    Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                    card_hallway.setVisibility(View.VISIBLE);
                    card_hallway.setAnimation(animSlide);
                    card_hallway.startAnimation(animSlide);

                    card_hallway_closeing.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                            card_hallway.setAnimation(animSlideout);
                            card_hallway.startAnimation(animSlideout);
                            card_hallway.setVisibility(View.GONE);
                            click_213.setClickable(true);
                            click_214.setClickable(true);
                            click_215.setClickable(true);
                            click_dowm.setClickable(true);
                            click_up.setClickable(true);
                            click_216.setClickable(true);
                            click_207.setClickable(true);
                            click_201.setClickable(true);
                            click_cc3.setClickable(true);
                            click_cc1.setClickable(true);
                           hallway.setClickable(true);

                            Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                            box.setVisibility(View.VISIBLE);
                            box.setAnimation(animSlide);
                            box.startAnimation(animSlide);
                        }
                    });
                }
            });
        });
        
//-=========================================Hallway=================================================//
        

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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);
                
                
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
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);

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
                                click_cc3.setClickable(true);
                                click_201.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);

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
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);

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
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);

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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);


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
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
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
                click_cc3.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);


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
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
                            }
                        });
                    }
                });
            }
        });
//-=========================================cc3=================================================//

        click_cc3.setOnClickListener(new View.OnClickListener() {
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
                click_cc3.setClickable(false);
                click_cc2.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);



                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_cc3.setVisibility(View.VISIBLE);
                        card_cc3.setAnimation(animSlide);
                        card_cc3.startAnimation(animSlide);

                        card_closing_cc3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_cc3.setAnimation(animSlideout);
                                card_cc3.startAnimation(animSlideout);
                                card_cc3.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                                click_cc3.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
                            }
                        });
                    }
                });
            }
        });
//-=========================================cc2=================================================//
        click_cc2.setOnClickListener(new View.OnClickListener() {
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
                click_cc3.setClickable(false);
                click_cc2.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_cc2.setVisibility(View.VISIBLE);
                        card_cc2.setAnimation(animSlide);
                        card_cc2.startAnimation(animSlide);

                        card_closing_cc2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_cc2.setAnimation(animSlideout);
                                card_cc2.startAnimation(animSlideout);
                                card_cc2.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                                click_cc3.setClickable(true);
                                click_cc2.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
                            }
                        });
                    }
                });
            }
        });
//-=========================================cc1=================================================//
        click_cc1.setOnClickListener(new View.OnClickListener() {
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
                click_cc3.setClickable(false);
                click_cc2.setClickable(false);
                click_cc1.setClickable(false);
               hallway.setClickable(false);

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                        box.setVisibility(View.GONE);
                        box.setAnimation(animSlideout);
                        box.startAnimation(animSlideout);

                        Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                        card_cc1.setVisibility(View.VISIBLE);
                        card_cc1.setAnimation(animSlide);
                        card_cc1.startAnimation(animSlide);

                        card_cc1_closeing.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                                card_cc1.setAnimation(animSlideout);
                                card_cc1.startAnimation(animSlideout);
                                card_cc1.setVisibility(View.GONE);

                                click_213.setClickable(true);
                                click_214.setClickable(true);
                                click_215.setClickable(true);
                                click_dowm.setClickable(true);
                                click_up.setClickable(true);
                                click_216.setClickable(true);
                                click_207.setClickable(true);
                                click_201.setClickable(true);
                                click_cc3.setClickable(true);
                                click_cc2.setClickable(true);
                                click_cc1.setClickable(true);
                               hallway.setClickable(true);

                                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                                box.setVisibility(View.VISIBLE);
                                box.setAnimation(animSlide);
                                box.startAnimation(animSlide);
                            }
                        });
                    }
                });
            }
        });

        //-=========================================hall click=================================================//

        //-=========================================navigation=================================================//

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                navigation_pannel.setVisibility(View.VISIBLE);
                navigation_pannel.setAnimation(animSlide);
                navigation_pannel.startAnimation(animSlide);

                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                box.setVisibility(View.GONE);
                box.setAnimation(animSlideout);
                box.startAnimation(animSlideout);
            }
        });

        navigation_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                navigation_pannel.setVisibility(View.GONE);
                navigation_pannel.setAnimation(animSlideout);
                navigation_pannel.startAnimation(animSlideout);

                Animation animSlide= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
                box.setVisibility(View.VISIBLE);
                box.setAnimation(animSlide);
                box.startAnimation(animSlide);
            }
        });

        card_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animSlideout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
                box.setVisibility(View.GONE);
                box.setAnimation(animSlideout);
                box.startAnimation(animSlideout);

                click_213.setClickable(true);
                click_214.setClickable(true);
                click_215.setClickable(true);
                click_dowm.setClickable(true);
                click_up.setClickable(true);
                click_216.setClickable(true);
                click_207.setClickable(true);
                click_201.setClickable(true);
                click_cc3.setClickable(true);
                click_cc2.setClickable(true);
                click_cc1.setClickable(true);
               hallway.setClickable(true);

            }
        });
        //-=========================================start navigation button=================================================//
        start_journey_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String user_current_location,user_destination_location;
               user_current_location = current_location.getText().toString();
                user_destination_location = destination_location.getText().toString();
                
                if (TextUtils.isEmpty(user_current_location)){
                    Toast.makeText(map.this, "Enter Current Location", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(user_destination_location)) {
                    Toast.makeText(map.this, "Enter  Destination", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.equals(user_current_location,user_destination_location)){
                    Toast.makeText(map.this, "AREY BHIYA!! JO KA DEKH LIYO :o ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}