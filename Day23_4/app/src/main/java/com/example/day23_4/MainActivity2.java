package com.example.day23_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView img2;

    void progressBar()
    {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2 = findViewById(R.id.imageview);
        img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int current = progressBar.getProgress();
                progressBar.setProgress(current + 10);
            }
        });
    }

    void progressBar1(){
        ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar1.getProgress();
                        if (current>= progressBar1.getMax()){
                            current=0;
                        }
                        progressBar1.setProgress(current + 10);
                    }
                    public void onFinish() {
                        Toast.makeText(MainActivity2.this,"Hết giờ",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }

    void progressBar2()
    {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = progressBar.getProgress();
                if (current>= progressBar.getMax()){
                    current=0;
                }
                progressBar.setProgress(current + 10); //thiết lập progress
            }
        });
    }

    void seekBar(){
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("AAA","Giá trị:" + progress);
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Start");
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Stop");
            }});
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar();
        progressBar2();
        progressBar1();
        seekBar();
    }
}