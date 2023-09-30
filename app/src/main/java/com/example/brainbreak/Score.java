package com.example.brainbreak;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView Scr,qn,grt;

    Button hom;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);



        Scr=findViewById(R.id.score);
        qn=findViewById(R.id.tqns);
        hom=findViewById(R.id.hmenu);
        grt=findViewById(R.id.greet);
        SharedPreferences sh=getSharedPreferences("Score",MODE_PRIVATE);
        int i=sh.getInt("Answer",0);
        int j=sh.getInt("Question",0);
        Scr.setText(String.valueOf(i));
        qn.setText(String.valueOf(j));

        if(i>5)
        {
            grt.setText("Well Done You have Passed");
        }
        else
        {
            grt.setText("Try Harder Buddy :)");
        }

        hom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(Score.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}