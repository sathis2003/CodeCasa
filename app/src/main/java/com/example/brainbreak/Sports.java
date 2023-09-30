package com.example.brainbreak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sports extends AppCompatActivity implements View.OnClickListener {


    Boolean spoptselected=false;
    CardView spqn,s1,s2,s3,s4;
    TextView spquesn,spopt1,spopt2,spopt3,spopt4;
    Button spnxt,sphome;

    int spcrtqn=0,spscore=0,spoptclicked;

    String[] questions = {
            "1) Which sport is known as the 'king of sports'?",
            "2) In which country did the sport of basketball originate?",
            "3) Who is often called 'The Greatest' in the sport of boxing?",
            "4) Which country won the FIFA World Cup in 2018?",
            "5) In which Olympic event might you perform the Fosbury Flop?",
            "6) Which tennis player has the most Grand Slam singles titles?",
            "7) What is the highest score possible in a game of bowling?",
            "8) Which city hosted the 2016 Summer Olympics?",
            "9) What is the diameter of a standard basketball hoop in inches?",
            "10) What is the most popular sport in the world?"
    };

    String[] spoption1 = {
            "a) Football",
            "a) USA",
            "a) Mike Tyson",
            "a) France",
            "a) Shot put",
            "a) Serena Williams",
            "a) 300",
            "a) London",
            "a) 16",
            "a) Cricket"
    };

    String[] spoption2 = {
            "b) Cricket",
            "b) Canada",
            "b) Sugar Ray Robinson",
            "b) Germany",
            "b) High jump",
            "b) Roger Federer",
            "b) 200",
            "b) Rio de Janeiro",
            "b) 18",
            "b) Soccer"
    };

    String[] spoption3 = {
            "c) Basketball",
            "c) Greece",
            "c) Muhammad Ali",
            "c) Brazil",
            "c) Long jump",
            "c) Rafael Nadal",
            "c) 400",
            "c) Tokyo",
            "c) 20",
            "c) Basketball"
    };

    String[] spoption4 = {
            "d) Tennis",
            "d) China",
            "d) Floyd Mayweather Jr.",
            "d) Russia",
            "d) Pole vault",
            "d) Novak Djokovic",
            "d) 300",
            "d) Beijing",
            "d) 22",
            "d) Baseball"
    };

    String[] spanswer = {
            "a) Football",
            "a) USA",
            "c) Muhammad Ali",
            "a) France",
            "b) High jump",
            "b) Roger Federer",
            "c) 400",
            "b) Rio de Janeiro",
            "c) 20",
            "c) Soccer"
    };
    
    int qns=questions.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        sphome=findViewById(R.id.sbutn1);
        spnxt=findViewById(R.id.sbutn2);
        spqn=findViewById(R.id.spq);
        s1=findViewById(R.id.sp1);
        s2=findViewById(R.id.sp2);
        s3=findViewById(R.id.sp3);
        s4=findViewById(R.id.sp4);

        spquesn=findViewById(R.id.squestion);
        spopt1=findViewById(R.id.soption1);
        spopt2=findViewById(R.id.soption2);
        spopt3=findViewById(R.id.soption3);
        spopt4=findViewById(R.id.soption4);


        spquesn.setText(questions[spcrtqn]);
        spopt1.setText(spoption1[spcrtqn]);
        spopt2.setText(spoption2[spcrtqn]);
        spopt3.setText(spoption3[spcrtqn]);
        spopt4.setText(spoption4[spcrtqn]);



        sphome.setOnClickListener(this);
        spnxt.setOnClickListener(this);
        spquesn.setOnClickListener(this);
        spopt1.setOnClickListener(this);
        spopt2.setOnClickListener(this);
        spopt3.setOnClickListener(this);
        spopt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sbutn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.sbutn2) {
            if (spcrtqn == 8) {
                spnxt.setText("Submit");
            }
            if (spoptselected) {
                if (spcrtqn < qns) {
                    spcrtqn++;
                    spopt2.setBackgroundColor(Color.CYAN);
                    spopt1.setBackgroundColor(Color.CYAN);
                    spopt3.setBackgroundColor(Color.CYAN);
                    spopt4.setBackgroundColor(Color.CYAN);

                    spquesn.setText(questions[spcrtqn]);
                    spopt1.setText(spoption1[spcrtqn]);
                    spopt2.setText(spoption2[spcrtqn]);
                    spopt3.setText(spoption3[spcrtqn]);
                    spopt4.setText(spoption4[spcrtqn]);

                    spoptclicked=0;
                    spoptselected = false;
                }
                else
                {
                    Intent in = new Intent(this, Score.class);
                    startActivity(in);
                }
            }
            else
            {
                Toast.makeText(this, "Choose any Answer", Toast.LENGTH_SHORT).show();
            }
        }
        if (spoptclicked==0) {
            if (view.getId() == R.id.soption1) {
                spoptclicked++;
                spoptselected = true;
                if (spopt1.getText().toString().equals(spanswer[spcrtqn])) {
                    spscore++;
                    spopt1.setBackgroundColor(Color.GREEN);
                } else {
                    spopt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.soption2) {
                spoptclicked++;
                spoptselected = true;
                if (spopt2.getText().toString().equals(spanswer[spcrtqn])) {
                    spscore++;
                    spopt2.setBackgroundColor(Color.GREEN);
                } else {
                    spopt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.soption3) {
                spoptclicked++;
                spoptselected = true;
                if (spopt3.getText().toString().equals(spanswer[spcrtqn])) {
                    spscore++;
                    spopt3.setBackgroundColor(Color.GREEN);
                } else {
                    spopt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.soption4) {
                spoptclicked++;
                spoptselected = true;
                if (spopt4.getText().toString().equals(spanswer[spcrtqn])) {
                    spscore++;
                    spopt4.setBackgroundColor(Color.GREEN);
                } else {
                    spopt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",spscore);
        ed.putInt("Questions",10);
        ed.apply();
    }
}