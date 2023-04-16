package com.example.berrypickingminigame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class berryPickingMinigame extends AppCompatActivity {
    int miniGame;
    ImageButton button;
    TextView textView;
    EditText editText;

    int berrysPicked = 0;
    int berrytimer = 3;
    int i = 0;
    int food = 0;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String output;
        {
            output = "Food Collected: " + String.valueOf(berrysPicked * 10);
        }

        ImageButton berry1 = findViewById(R.id.imageButton);
        ImageButton berry2 = findViewById(R.id.imageButton2);
        ImageButton berry3 = findViewById(R.id.imageButton3);
        ImageButton berry4 = findViewById(R.id.imageButton4);
        TextView btime = findViewById(R.id.textView3);
        TextView score = findViewById(R.id.berryscore);
        TextView counter1 = findViewById(R.id.centerTimer);


        counter1.setElevation(Float.parseFloat("40dp"));
        new CountDownTimer(3000, 1000) {
            private int berrytimer = this.berrytimer;

            public void onTick(long millisUntilFinished) {

                counter1.setText(String.valueOf(this.berrytimer));
                this.berrytimer--;
            }

            public void onFinish() {
                new CountDownTimer(1000, 1000) {
                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {
                        counter1.setText("Go!!");
                    }

                    public void onFinish() {
                        counter1.setElevation(Float.parseFloat("-40dp"));

                        counter1.setVisibility(View.INVISIBLE);
                    }
                }.start();
            }
        }.start();


        new CountDownTimer(10000, 1000) {
            private final int berrytimer = this.berrytimer;

            public void onTick(long millisUntilFinished) {
                btime.setText(String.valueOf(1 + millisUntilFinished / 1000));
                berry1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        berrysPicked = berrysPicked + 1;
                        score.setText(output);
                    }
                });
                berry2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        berrysPicked++;
                        score.setText(output);
                    }
                });
                berry3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        berrysPicked = berrysPicked + 1;
                        score.setText(output);
                    }
                });
                berry4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        berrysPicked = berrysPicked + 1;
                        score.setText(output);
                    }
                });
            }

            @SuppressLint("SetTextI18n")
            public void onFinish() {
                counter1.setElevation(Float.parseFloat("40dp"));
                counter1.setVisibility(View.VISIBLE);

                counter1.setText("END");
            }
        }.start();
        //food = food + 10* berries picked.;
    }
}