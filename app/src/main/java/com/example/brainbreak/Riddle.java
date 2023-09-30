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

public class Riddle extends AppCompatActivity implements View.OnClickListener {

    Boolean roptselected=false;
    CardView rqn,r1,r2,r3,r4;
    TextView rquesn,ropt1,ropt2,ropt3,ropt4;
    Button rnxt,rhome;

    int rcrtqn=0,rscore=0,roptclicked;


    String[] questions = {
            "1) What is the capital of France?",
            "2) Who wrote the play 'Romeo and Juliet'?",
            "3) Which gas do plants absorb from the atmosphere and use for photosynthesis?",
            "4) Which planet is known as the 'Red Planet'?",
            "5) What is the chemical symbol for gold?",
            "6) What is the largest planet in our solar system?",
            "7) Who painted the 'Mona Lisa'?",
            "8) Which element is essential for human respiration?",
            "9) What is the powerhouse of the cell?",
            "10) What is the tallest mountain in the world?"
    };

    String[] roption1 = {
            "a) London",
            "a) Charles Dickens",
            "a) Oxygen",
            "a) Venus",
            "a) Ag",
            "a) Earth",
            "a) Vincent van Gogh",
            "a) Nitrogen",
            "a) Nucleus",
            "a) Mount Kilimanjaro"
    };

    String[] roption2 = {
            "b) Berlin",
            "b) William Shakespeare",
            "b) Carbon dioxide",
            "b) Earth",
            "b) Ge",
            "b) Mars",
            "b) Leonardo da Vinci",
            "b) Oxygen",
            "b) Mitochondria",
            "b) Mount McKinley"
    };

    String[] roption3 = {
            "c) Paris",
            "c) Jane Austen",
            "c) Nitrogen",
            "c) Mars",
            "c) Au",
            "c) Jupiter",
            "c) Pablo Picasso",
            "c) Hydrogen",
            "c) Chloroplast",
            "c) Mount Everest"
    };

    String[] roption4 = {
            "d) Rome",
            "d) F. Scott Fitzgerald",
            "d) Hydrogen",
            "d) Jupiter",
            "d) Cu",
            "d) Saturn",
            "d) Michelangelo",
            "d) Carbon dioxide",
            "d) Endoplasmic reticulum",
            "d) K2"
    };

    String[] answer = {
            "c) Paris",
            "b) William Shakespeare",
            "b) Carbon dioxide",
            "c) Mars",
            "c) Au",
            "c) Jupiter",
            "d) Leonardo da Vinci",
            "b) Oxygen",
            "c) Chloroplast",
            "d) Mount Everest"
    };
    
    int qns=questions.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);

        rhome=findViewById(R.id.rbutn1);
        rnxt=findViewById(R.id.rbutn2);
        rqn=findViewById(R.id.ridq);
        r1=findViewById(R.id.rid1);
        r2=findViewById(R.id.rid2);
        r3=findViewById(R.id.rid3);
        r4=findViewById(R.id.rid4);

        rquesn=findViewById(R.id.rquestion);
        ropt1=findViewById(R.id.roption1);
        ropt2=findViewById(R.id.roption2);
        ropt3=findViewById(R.id.roption3);
        ropt4=findViewById(R.id.roption4);


        rquesn.setText(questions[rcrtqn]);
        ropt1.setText(roption1[rcrtqn]);
        ropt2.setText(roption2[rcrtqn]);
        ropt3.setText(roption3[rcrtqn]);
        ropt4.setText(roption4[rcrtqn]);



        rhome.setOnClickListener(this);
        rnxt.setOnClickListener(this);
        rquesn.setOnClickListener(this);
        ropt1.setOnClickListener(this);
        ropt2.setOnClickListener(this);
        ropt3.setOnClickListener(this);
        ropt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.rbutn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.rbutn2) {
            if (rcrtqn == 3) {
                rnxt.setText("Submit");
            }
            if (roptselected) {
                if (rcrtqn < qns) {
                    rcrtqn++;
                    ropt2.setBackgroundColor(Color.CYAN);
                    ropt1.setBackgroundColor(Color.CYAN);
                    ropt3.setBackgroundColor(Color.CYAN);
                    ropt4.setBackgroundColor(Color.CYAN);

                    rquesn.setText(questions[rcrtqn]);
                    ropt1.setText(roption1[rcrtqn]);
                    ropt2.setText(roption2[rcrtqn]);
                    ropt3.setText(roption3[rcrtqn]);
                    ropt4.setText(roption4[rcrtqn]);

                    roptclicked=0;
                    roptselected = false;
                }
                else
                {
                    Intent in = new Intent(this, Score.class);
                    startActivity(in);
                }
            }
            else
            {
                Toast.makeText(this, "Choose any answerwer", Toast.LENGTH_SHORT).show();
            }
        }
        if (roptclicked==0) {
            if (view.getId() == R.id.roption1) {
                roptclicked++;
                roptselected = true;
                if (ropt1.getText().toString().equals(answer[rcrtqn])) {
                    rscore++;
                    ropt1.setBackgroundColor(Color.GREEN);
                } else {
                    ropt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.roption2) {
                roptclicked++;
                roptselected = true;
                if (ropt2.getText().toString().equals(answer[rcrtqn])) {
                    rscore++;
                    ropt2.setBackgroundColor(Color.GREEN);
                } else {
                    ropt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.roption3) {
                roptclicked++;
                roptselected = true;
                if (ropt3.getText().toString().equals(answer[rcrtqn])) {
                    rscore++;
                    ropt3.setBackgroundColor(Color.GREEN);
                } else {
                    ropt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.roption4) {
                roptclicked++;
                roptselected = true;
                if (ropt4.getText().toString().equals(answer[rcrtqn])) {
                    rscore++;
                    ropt4.setBackgroundColor(Color.GREEN);
                } else {
                    ropt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",rscore);
        ed.putInt("Questions",10);
        ed.apply();
    }
}