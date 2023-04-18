package com.example.berrypickingminigame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class berryPickingMinigame extends AppCompatActivity {
    int miniGame;
    ImageButton button;
    TextView textView;
    EditText editText;
    TextView score;

    int numOfBerryPicked = 0;
    int BERRY_TIMER = 3;
    int i = 0;
    int food = 0;
    private String output;
    private Boolean miniGameRunning = false;

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
        TextView btime = findViewById(R.id.textView3);
        score = findViewById(R.id.berryscore);
        TextView counter1 = findViewById(R.id.centerTimer);

        berry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
            }
        });
        berry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
            }
        });
        berry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
            }
        });
        berry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
            }
        });

        // COUNTDOWN STARTS
        counter1.setElevation(Float.parseFloat("40.0"));
        makeInvisible(berry1);
        makeInvisible(berry2);
        makeInvisible(berry3);
        makeInvisible(berry4);
        new CountDownTimer(3000, 1000) {
            int berrytimer = BERRY_TIMER;

            public void onTick(long millisUntilFinished) {

                counter1.setText(String.valueOf(this.berrytimer));
                this.berrytimer--;
            }

            // COUNTDOWN FINSISHES
            public void onFinish() {
                new CountDownTimer(1000, 1000) {


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
                        counter1.setVisibility(View.INVISIBLE);
                        counter1.setElevation(Float.parseFloat("-40.0"));
                        miniGameRunning = true;

                        new CountDownTimer(11000, 1000) {
                            public void onTick(long millisUntilFinished) {
                                btime.setText(String.valueOf(millisUntilFinished / 1000));

                            }

                            // GAME FINISHES
                            @SuppressLint("SetTextI18n")
                            public void onFinish() {
                                makeInvisible(berry1);
                                makeInvisible(berry2);
                                makeInvisible(berry3);
                                makeInvisible(berry4);
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



        //food = food + 5 * berries picked.;
    }

    private void berryPicked(){
        if(miniGameRunning){
            numOfBerryPicked++;
            score.setText(String.valueOf(numOfBerryPicked * 5));
        }
    }

    private void makeVisible(ImageButton img){
        img.setElevation(Float.parseFloat("3"));
        img.setVisibility(View.VISIBLE);
    }
    private void makeInvisible(ImageButton img){
        img.setElevation(Float.parseFloat("-3"));
        img.setVisibility(View.INVISIBLE);

    }

}