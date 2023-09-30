package com.example.brainbreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Technology extends AppCompatActivity implements View.OnClickListener {

    Boolean toptselected=false;

    CardView tqn,t1,t2,t3,t4;
    TextView tquesn,topt1,topt2,topt3,topt4;
    Button tnxt,thome;
    int tcrtqn=0,tscore=0,toptclicked;

    String[] tQuestions = {
            "1) Which tech company is known for its 'iDevices' like iPhone and iPad?",
            "2) What does 'CPU' stand for in the context of computers?",
            "3) Which programming language is known for its use in web development and is often abbreviated as 'JS'?",
            "4) What is the term for a malicious software that can replicate itself and spread to other computers?",
            "5) Who is the co-founder of Microsoft Corporation?",
            "6) What does 'HTML' stand for in web development?",
            "7) Which company developed the Android operating system?",
            "8) What is the largest social media platform in the world?",
            "9) Which technology is used for wireless communication between devices over short distances?",
            "10) What is the world's largest technology company by revenue as of 2021?"
    };

    String[] tOption1 = {
            "a) Google",
            "a) Central Processing Unit",
            "a) Java",
            "a) Trojan",
            "a) Steve Jobs",
            "a) HyperText Markup Language",
            "a) Apple",
            "a) Twitter",
            "a) Bluetooth",
            "a) Microsoft"
    };

    String[] tOption2 = {
            "b) Apple",
            "b) Computer Personal Unit",
            "b) Python",
            "b) Virus",
            "b) Bill Gates",
            "b) Hypertext Transfer Protocol",
            "b) Google",
            "b) Instagram",
            "b) Wi-Fi",
            "b) Amazon"
    };

    String[] tOption3 = {
            "c) Microsoft",
            "c) Central Processing Unit",
            "c) JavaScript",
            "c) Worm",
            "c) Larry Page",
            "c) HyperTransfer Markup Language",
            "c) Samsung",
            "c) Facebook",
            "c) NFC",
            "c) Apple"
    };

    String[] tOption4 = {
            "d) Facebook",
            "d) Central Personal Unit",
            "d) Ruby",
            "d) Spyware",
            "d) Mark Zuckerberg",
            "d) Hypertext Markup Language",
            "d) Huawei",
            "d) TikTok",
            "d) RFID",
            "d) Google"
    };

    String[] tAns= {
            "b) Apple",
            "a) Central Processing Unit",
            "c) JavaScript",
            "b) Virus",
            "b) Bill Gates",
            "a) HyperText Markup Language",
            "c) Google",
            "c) Facebook",
            "a) Bluetooth",
            "d) Apple"
    };

    int qns=tQuestions.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);

        thome=findViewById(R.id.tbutn1);
        tnxt=findViewById(R.id.tbutn2);
        tqn=findViewById(R.id.thq);
        t1=findViewById(R.id.th1);
        t2=findViewById(R.id.th2);
        t3=findViewById(R.id.th3);
        t4=findViewById(R.id.th4);
        tquesn=findViewById(R.id.tquestion);
        topt1=findViewById(R.id.toption1);
        topt2=findViewById(R.id.toption2);
        topt3=findViewById(R.id.toption3);
        topt4=findViewById(R.id.toption4);
        
        tquesn.setText(tQuestions[tcrtqn]);
        topt1.setText(tOption1[tcrtqn]);
        topt2.setText(tOption2[tcrtqn]);
        topt3.setText(tOption3[tcrtqn]);
        topt4.setText(tOption4[tcrtqn]);
        
        thome.setOnClickListener(this);
        tnxt.setOnClickListener(this);
        tquesn.setOnClickListener(this);
        topt1.setOnClickListener(this);
        topt2.setOnClickListener(this);
        topt3.setOnClickListener(this);
        topt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.tbutn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.tbutn2) {
            if (tcrtqn == 3) {
                tnxt.setText("Submit");
            }
            if (toptselected) {
                if (tcrtqn < qns) {
                    tcrtqn++;
                    topt2.setBackgroundColor(Color.CYAN);
                    topt1.setBackgroundColor(Color.CYAN);
                    topt3.setBackgroundColor(Color.CYAN);
                    topt4.setBackgroundColor(Color.CYAN);

                    tquesn.setText(tQuestions[tcrtqn]);
                    topt1.setText(tOption1[tcrtqn]);
                    topt2.setText(tOption2[tcrtqn]);
                    topt3.setText(tOption3[tcrtqn]);
                    topt4.setText(tOption4[tcrtqn]);

                    toptclicked=0;
                    toptselected = false;
                }
                else
                {
                    Intent in = new Intent(this, Score.class);
                    startActivity(in);
                }
            }
            else
            {
                Toast.makeText(this, "Choose any answer", Toast.LENGTH_SHORT).show();
            }
        }
        if (toptclicked==0) {
            if (view.getId() == R.id.toption1) {
                toptclicked++;
                toptselected = true;
                if (topt1.getText().toString().equals(tAns[tcrtqn])) {
                    tscore++;
                    topt1.setBackgroundColor(Color.GREEN);
                } else {
                    topt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.toption2) {
                toptclicked++;
                toptselected = true;
                if (topt2.getText().toString().equals(tAns[tcrtqn])) {
                    tscore++;
                    topt2.setBackgroundColor(Color.GREEN);
                } else {
                    topt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.toption3) {
                toptclicked++;
                toptselected = true;
                if (topt3.getText().toString().equals(tAns[tcrtqn])) {
                    tscore++;
                    topt3.setBackgroundColor(Color.GREEN);
                } else {
                    topt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.toption4) {
                toptclicked++;
                toptselected = true;
                if (topt4.getText().toString().equals(tAns[tcrtqn])) {
                    tscore++;
                    topt4.setBackgroundColor(Color.GREEN);
                } else {
                    topt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",tscore);
        ed.putInt("Questions",10);
        ed.apply();
    }
}