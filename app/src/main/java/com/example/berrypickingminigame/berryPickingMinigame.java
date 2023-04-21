package com.example.berrypickingminigame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.view.ViewGroup.MarginLayoutParams;

public class berryPickingMinigame extends AppCompatActivity {
    int miniGame;
    ImageButton button;
    TextView textView;
    EditText editText;
    TextView score;

    int numOfBerryPicked = 0;
    int BERRY_TIMER = 3;
    int GAMETIME = 10; // how long the game runs for
    int GAMETIMEMS = GAMETIME * 1000;
    public double BERRY_DELAY = 0.6;  //seconds until berry re-appears.
    int i = 0;
    int food = 0;
    private String output;
    private Boolean miniGameRunning = false;
    Random rand = new Random();

    protected void onCreate(Bundle savedInstanceState) {


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berryberryminigame);

        ImageButton berry1 = findViewById(R.id.imageButton);
        ImageButton berry2 = findViewById(R.id.imageButton2);
        ImageButton berry3 = findViewById(R.id.imageButton3);
        ImageButton berry4 = findViewById(R.id.imageButton4);
        ImageButton berry5 = findViewById(R.id.imageButton5);
        TextView btime = findViewById(R.id.textView3);
        score = findViewById(R.id.berryscore);
        TextView counter1 = findViewById(R.id.centerTimer);

        berry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry1);
            }
        });
        berry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry2);
            }
        });
        berry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry3);
            }
        });
        berry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry4);
            }
        });
        berry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry5);
            }
        });

        // COUNTDOWN STARTS
        counter1.setElevation(Float.parseFloat("40.0"));
        makeInvisible(berry1);
        makeInvisible(berry2);
        makeInvisible(berry3);
        makeInvisible(berry4);
        makeInvisible(berry5);

        new CountDownTimer(1200, 600) {

            @SuppressLint("SetTextI18n")
            public void onTick(long milisUntilFinished) {
                counter1.setText("Berry Picking Minigame");
            }

            public void onFinish() {

                new CountDownTimer(1800, 600) {
                    int berrytimer = BERRY_TIMER;

                    public void onTick(long millisUntilFinished) {
                        counter1.setText(String.valueOf(this.berrytimer));
                        this.berrytimer--;
                    }

                    // COUNTDOWN FINISHES
                    public void onFinish() {
                        new CountDownTimer(600, 600) {


                            // GAME STARTS
                            @SuppressLint("SetTextI18n")
                            public void onTick(long millisUntilFinished) {
                                counter1.setText("Go!!");
                            }

                            public void onFinish() {
                                makeVisible(berry1);
                                makeVisible(berry2);
                                makeVisible(berry3);
                                makeVisible(berry4);
                                makeVisible(berry5);
                                counter1.setVisibility(View.INVISIBLE);
                                counter1.setElevation(Float.parseFloat("-40.0"));
                                miniGameRunning = true;

                                new CountDownTimer(GAMETIMEMS + 1000, 1000) {
                                    public void onTick(long millisUntilFinished) {
                                        btime.setText(String.valueOf(millisUntilFinished / 1000));

                                    }

                                    // GAME FINISHES
                                    @SuppressLint("SetTextI18n")
                                    public void onFinish() {
                                        miniGameRunning = false;
                                        makeInvisible(berry1);
                                        makeInvisible(berry2);
                                        makeInvisible(berry3);
                                        makeInvisible(berry4);
                                        makeInvisible(berry5);
                                        counter1.setElevation(Float.parseFloat("40"));
                                        counter1.setVisibility(View.VISIBLE);
                                        counter1.setText("Finished!");
                                        miniGameRunning = false;
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
        //food = food + 5 * berries picked.;
    }

    private void berryPicked() {
        if (miniGameRunning) {
            numOfBerryPicked++;
            score.setText(String.valueOf(numOfBerryPicked * 5));
        }
    }

    private void moveBerry(ImageButton img) {
        makeInvisible(img);
        //img.setMarginTop(48 + rand.nextInt(208-48));
        //img.setMarginEnd(52 + rand.nextInt(404-52));


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (miniGameRunning) {
                    makeVisible(img);
                }
            }
        }, (int) (BERRY_DELAY * 1000));
        /*
        final Timer t = new java.util.Timer();
        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        makeVisible(img);
                        t.cancel();
                    }
                },
                1000, 500
        );*/
    }

    private void makeVisible(ImageButton img) {
        img.setElevation(Float.parseFloat("1"));
        img.setVisibility(View.VISIBLE);
    }

    private void makeInvisible(ImageButton img) {
        img.setElevation(Float.parseFloat("-10"));
        img.setVisibility(View.INVISIBLE);

    }
}