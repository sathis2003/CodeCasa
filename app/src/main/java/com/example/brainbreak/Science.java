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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Science extends AppCompatActivity implements View.OnClickListener
{

    CardView qn,o1,o2,o3,o4;
    Boolean optselected=false;
    TextView quesn,opt1,opt2,opt3,opt4;
    Button nxt,home;

    int crtqn=0;
    int score=0,optclicked;

    String[] sqn = {
            "1) What is the chemical symbol for gold?",
            "2) Which gas do plants absorb from the atmosphere and use for photosynthesis?",
            "3) What is the process by which plants make their own food using sunlight?",
            "4) Which planet is known as the \"Red Planet\"?",
            "5) What is the chemical formula for water?",
            "6) Which of the following is the smallest subatomic particle?",
            "7) What is the SI unit of energy?",
            "8) Which gas makes up the majority of Earth's atmosphere?",
            "9) What is the process by which heat is transferred through a material without any movement of the material itself?",
            "10) What is the chemical symbol for iron?"
    };

    String[] soption1 = {
            "a) Ag",
            "a) Oxygen",
            "a) Respiration",
            "a) Venus",
            "a) CO2",
            "a) Electron",
            "a) Watt",
            "a) Oxygen",
            "a) Convection",
            "a) Ir"
    };

    String[] soption2 = {
            "b) Ge",
            "b) Carbon dioxide",
            "b) Fermentation",
            "b) Earth",
            "b) H2O",
            "b) Proton",
            "b) Joule",
            "b) Nitrogen",
            "b) Conduction",
            "b) Fe"
    };

    String[] soption3 = {
            "c) Au",
            "c) Nitrogen",
            "c) Photosynthesis",
            "c) Mars",
            "c) CH4",
            "c) Neutron",
            "c) Volt",
            "c) Carbon dioxide",
            "c) Radiation",
            "c) In"
    };

    String[] soption4 = {
            "d) Cu",
            "d) Hydrogen",
            "d) Digestion",
            "d) Jupiter",
            "d) O2",
            "d) Nucleus",
            "d) Ampere",
            "d) Hydrogen",
            "d) Expansion",
            "d) Si"
    };

    String[] sans = {
            "c) Au",
            "b) Carbon dioxide",
            "c) Photosynthesis",
            "c) Mars",
            "b) H2O",
            "a) Electron",
            "b) Joule",
            "b) Nitrogen",
            "b) Conduction",
            "b) Fe"
    };


    int qns=sqn.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        home=findViewById(R.id.butn1);
        nxt=findViewById(R.id.butn2);
        qn=findViewById(R.id.sciqn);
        o1=findViewById(R.id.sci1);
        o2=findViewById(R.id.sci2);
        o3=findViewById(R.id.sci3);
        o4=findViewById(R.id.sci4);
        quesn=findViewById(R.id.question);
        opt1=findViewById(R.id.option1);
        opt2=findViewById(R.id.option2);
        opt3=findViewById(R.id.option3);
        opt4=findViewById(R.id.option4);



        quesn.setText(sqn[crtqn]);
        opt1.setText(soption1[crtqn]);
        opt2.setText(soption2[crtqn]);
        opt3.setText(soption3[crtqn]);
        opt4.setText(soption4[crtqn]);



        home.setOnClickListener(this);
        nxt.setOnClickListener(this);
        quesn.setOnClickListener(this);
        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.butn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.butn2) {
            if (crtqn == 8) {
                nxt.setText("Submit");
            }
            if (optselected) {
                if (crtqn < qns) {
                    ++crtqn;
                    opt2.setBackgroundColor(Color.CYAN);
                    opt1.setBackgroundColor(Color.CYAN);
                    opt3.setBackgroundColor(Color.CYAN);
                    opt4.setBackgroundColor(Color.CYAN);

                    quesn.setText(sqn[crtqn]);
                    opt1.setText(soption1[crtqn]);
                    opt2.setText(soption2[crtqn]);
                    opt3.setText(soption3[crtqn]);
                    opt4.setText(soption4[crtqn]);
                }
                else
                {
                    Intent in = new Intent(this, Score.class);
                    startActivity(in);
                }
                optclicked=0;
                optselected = false;
            }
            else
            {
                Toast.makeText(this, "Choose any answer", Toast.LENGTH_SHORT).show();
            }
        }
        if (optclicked==0) {
            if (view.getId() == R.id.option1) {
                optclicked++;
                optselected = true;
                if (opt1.getText().toString().equals(sans[crtqn])) {
                    score++;
                    opt1.setBackgroundColor(Color.GREEN);
                } else {
                    opt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.option2) {
                optclicked++;
                optselected = true;
                if (opt2.getText().toString().equals(sans[crtqn])) {
                    score++;
                    opt2.setBackgroundColor(Color.GREEN);
                } else {
                    opt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.option3) {
                optclicked++;
                optselected = true;
                if (opt3.getText().toString().equals(sans[crtqn])) {
                    score++;
                    opt3.setBackgroundColor(Color.GREEN);
                } else {
                    opt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.option4) {
                optclicked++;
                optselected = true;
                if (opt4.getText().toString().equals(sans[crtqn])) {
                    score++;
                    opt4.setBackgroundColor(Color.GREEN);
                } else {
                    opt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",score);
        ed.putInt("Question",10);
        ed.apply();
    }
}