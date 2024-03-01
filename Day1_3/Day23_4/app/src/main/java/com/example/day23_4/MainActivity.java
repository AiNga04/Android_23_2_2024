package com.example.day23_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout bg;
    ImageButton img1;
    Switch sw;
    CheckBox ck1;
    RadioGroup radioGroup;

    public void rdbackground (){
        ConstraintLayout bg = (ConstraintLayout)
                findViewById(R.id.constraintLayout1);
        bg.setBackgroundColor(Color.BLUE);
        bg.setBackgroundResource(R.drawable.bg1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        ImageButton img2 = (ImageButton)
                findViewById(R.id.imageButton1);
        img2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                img1.setImageResource(R.drawable.on);
                img1.getLayoutParams().width=550;
                img1.getLayoutParams().height=550;
            }
        });

        //switch
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(MainActivity.this,"Wifi đang bật",Toast.LENGTH_LONG).show();}
                else{
                    Toast.makeText(MainActivity.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });

        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck1.setOnCheckedChangeListener(new
        CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
           if(isChecked){
               bg.setBackgroundResource(R.drawable.bg1);
           }else{
               bg.setBackgroundResource(R.drawable.bg2);
           }
        }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group,int checkedId) {
        if(checkedId == R.id.radioButton)
              bg.setBackgroundResource(R.drawable.bg3);
          else if(checkedId == R.id.radioButton2)
              bg.setBackgroundResource(R.drawable.bg4);
        }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdbackground();
    }
}


