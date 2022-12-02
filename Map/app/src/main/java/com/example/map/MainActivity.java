package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button basemapBtn;
    Button maptypeBtn;
    Button personalizeBtn;
    Button districtBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button basemapBtn=(Button) findViewById(R.id.basemapbtn);
        basemapBtn.setOnClickListener(basemapBtnListner);

        Button maptypeBtn=(Button) findViewById(R.id.maptypebtn);
        maptypeBtn.setOnClickListener(maptypeBtnListner);

        Button personalizeBtn=(Button) findViewById(R.id.personalizebtn);
        personalizeBtn.setOnClickListener(personalizeBtnListner);

        Button districtBtn=(Button) findViewById(R.id.districtbtn);
        districtBtn.setOnClickListener(districtbtnListner);
    }

    Button.OnClickListener basemapBtnListner=new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,BaseMapActivity.class);
            startActivity(intent);
        }
    };

    Button.OnClickListener maptypeBtnListner=new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,MapTypeActivity.class);
            startActivity(intent);
        }
    };

    Button.OnClickListener personalizeBtnListner=new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,PersonalizeMapActivity.class);
            startActivity(intent);
        }
    };
    Button.OnClickListener districtbtnListner=new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,DistrictActivity.class);
            startActivity(intent);
        }
    };





}