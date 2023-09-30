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

public class Gk extends AppCompatActivity implements View.OnClickListener {

    Boolean goptselected=false;
    CardView gquesn,gopt1,gopt2,gopt3,gopt4;
    TextView ggquesn,ggopt2,ggopt3,ggopt4,ggopt1;
    Button gnxt,ghome;

    int gcrtqn=0;
    int gscore=0,goptclicked;

    String[] gkQuestions = {
            "1) Which planet is known as the \"Red Planet\"?",
            "2) Who wrote the play 'Romeo and Juliet'?",
            "3) What is the capital of France?",
            "4) Who painted the Mona Lisa?",
            "5) What is the largest mammal in the world?",
            "6) Which country is known as the 'Land of the Rising Sun'?",
            "7) What is the currency of Japan?",
            "8) Who is the current President of the United States?",
            "9) Which gas do plants absorb from the atmosphere and use for photosynthesis?",
            "10) Which famous scientist formulated the theory of general relativity?"
    };

    String[] gkOption1 = {
            "a) Venus",
            "a) William Shakespeare",
            "a) London",
            "a) Vincent van Gogh",
            "a) Elephant",
            "a) China",
            "a) Yen",
            "a) Barack Obama",
            "a) Oxygen",
            "a) Isaac Newton"
    };

    String[] gkOption2 = {
            "b) Earth",
            "b) Charles Dickens",
            "b) Berlin",
            "b) Pablo Picasso",
            "b) Blue whale",
            "b) South Korea",
            "b) Dollar",
            "b) Joe Biden",
            "b) Carbon dioxide",
            "b) Albert Einstein"
    };

    String[] gkOption3 = {
            "c) Mars",
            "c) Jane Austen",
            "c) Paris",
            "c) Leonardo da Vinci",
            "c) Giraffe",
            "c) Japan",
            "c) Euro",
            "c) Donald Trump",
            "c) Nitrogen",
            "c) Galileo Galilei"
    };

    String[] gkOption4 = {
            "d) Jupiter",
            "d) F. Scott Fitzgerald",
            "d) Rome",
            "d) Michelangelo",
            "d) Rhinoceros",
            "d) India",
            "d) Pound",
            "d) George W. Bush",
            "d) Hydrogen",
            "d) Marie Curie"
    };

    String[] gkAns = {
            "c) Mars",
            "a) William Shakespeare",
            "c) Paris",
            "c) Leonardo da Vinci",
            "b) Blue whale",
            "c) Japan",
            "a) Yen",
            "b) Joe Biden",
            "c) Carbon dioxide",
            "b) Albert Einstein"
    };



    int qns=gkQuestions.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk);

        ghome=findViewById(R.id.gbutn1);
        gnxt=findViewById(R.id.gbutn2);
        gquesn=findViewById(R.id.gquestion);
        gopt1=findViewById(R.id.goption1);
        gopt2=findViewById(R.id.goption2);
        gopt3=findViewById(R.id.goption3);
        gopt4=findViewById(R.id.goption4);
        ggquesn=findViewById(R.id.ggquestion);
        ggopt1=findViewById(R.id.ggoption1);
        ggopt2=findViewById(R.id.ggoption2);
        ggopt3=findViewById(R.id.ggoption3);
        ggopt4=findViewById(R.id.ggoption4);


        ggquesn.setText(gkQuestions[gcrtqn]);
        ggopt1.setText(gkOption1[gcrtqn]);
        ggopt2.setText(gkOption2[gcrtqn]);
        ggopt3.setText(gkOption3[gcrtqn]);
        ggopt4.setText(gkOption4[gcrtqn]);



        ghome.setOnClickListener(this);
        gnxt.setOnClickListener(this);
        gquesn.setOnClickListener(this);
        gopt1.setOnClickListener(this);
        gopt2.setOnClickListener(this);
        gopt3.setOnClickListener(this);
        gopt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.gbutn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.gbutn2) {
            if (gcrtqn == 3) {
                gnxt.setText("Submit");
            }
            if (goptselected) {
                if (gcrtqn < qns) {
                    gcrtqn++;
                    ggopt2.setBackgroundColor(Color.CYAN);
                    ggopt1.setBackgroundColor(Color.CYAN);
                    ggopt3.setBackgroundColor(Color.CYAN);
                    ggopt4.setBackgroundColor(Color.CYAN);

                    ggquesn.setText(gkQuestions[gcrtqn]);
                    ggopt1.setText(gkOption1[gcrtqn]);
                    ggopt2.setText(gkOption2[gcrtqn]);
                    ggopt3.setText(gkOption3[gcrtqn]);
                    ggopt4.setText(gkOption4[gcrtqn]);
                    goptclicked=0;
                    goptselected = false;
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
        if (goptclicked==0) {
            if (view.getId() == R.id.goption1) {
                goptclicked++;
                goptselected = true;
                if (ggopt1.getText().toString().equals(gkAns[gcrtqn])) {
                    gscore++;
                    ggopt1.setBackgroundColor(Color.GREEN);
                } else {
                    ggopt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.goption2) {
                goptclicked++;
                goptselected = true;
                if (ggopt2.getText().toString().equals(gkAns[gcrtqn])) {
                    gscore++;
                    ggopt2.setBackgroundColor(Color.GREEN);
                } else {
                    ggopt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.goption3) {
                goptclicked++;
                goptselected = true;
                if (ggopt3.getText().toString().equals(gkAns[gcrtqn])) {
                    gscore++;
                    ggopt3.setBackgroundColor(Color.GREEN);
                } else {
                    ggopt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.goption4) {
                goptclicked++;
                goptselected = true;
                if (ggopt4.getText().toString().equals(gkAns[gcrtqn])) {
                    gscore++;
                    ggopt4.setBackgroundColor(Color.GREEN);
                } else {
                    ggopt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",gscore);
        ed.putInt("Questions",gcrtqn);
        ed.apply();
    }
}