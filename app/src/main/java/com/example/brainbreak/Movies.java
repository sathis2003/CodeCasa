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

public class Movies extends AppCompatActivity implements View.OnClickListener{

    Boolean moptselected=false;
    CardView mqn,m1,m2,m3,m4;
    TextView mquesn,mopt1,mopt2,mopt3,mopt4;
    Button mnxt,mhome;

    int mcrtqn=0,mscore=0,moptclicked;


    String[] movieQuestions = {
            "1) Who directed the movie 'The Shawshank Redemption'?",
            "2) Which film won the Academy Award for Best Picture in 1994?",
            "3) In 'The Lord of the Rings' trilogy, who played the role of Frodo Baggins?",
            "4) Which actor portrayed the character Jack Dawson in the movie 'Titanic'?",
            "5) Which film features a computer program called 'The Matrix'?",
            "6) Who won the Academy Award for Best Actor for his role in the movie 'Forrest Gump'?",
            "7) In 'Star Wars: Episode IV - A New Hope,' what is the call sign of Luke Skywalker's X-wing fighter?",
            "8) Who played the lead role in the 'Pirates of the Caribbean' film series?",
            "9) Which animated film tells the story of a young lion named Simba?",
            "10) Which actress starred as Elle Woods in the movie 'Legally Blonde'?"
    };

    String[] movieOption1 = {
            "a) Martin Scorsese",
            "a) Pulp Fiction",
            "a) Elijah Wood",
            "a) Leonardo DiCaprio",
            "a) The Terminator",
            "a) Tom Hanks",
            "a) X-wing Red 5",
            "a) Johnny Depp",
            "a) Beauty and the Beast",
            "a) Reese Witherspoon"
    };

    String[] movieOption2 = {
            "b) Quentin Tarantino",
            "b) Braveheart",
            "b) Daniel Radcliffe",
            "b) Brad Pitt",
            "b) Inception",
            "b) Robert De Niro",
            "b) X-wing Blue 2",
            "b) Orlando Bloom",
            "b) Aladdin",
            "b) Julia Roberts"
    };

    String[] movieOption3 = {
            "c) Christopher Nolan",
            "c) Forrest Gump",
            "c) Rupert Grint",
            "c) Matt Damon",
            "c) The Matrix",
            "c) Russell Crowe",
            "c) X-wing Rogue 1",
            "c) Will Smith",
            "c) The Lion King",
            "c) Meryl Streep"
    };

    String[] movieOption4 = {
            "d) Frank Darabont",
            "d) Schindler's List",
            "d) Sean Astin",
            "d) Tom Cruise",
            "d) Star Trek",
            "d) Tom Cruise",
            "d) X-wing Red Leader",
            "d) Keanu Reeves",
            "d) Mulan",
            "d) Nicole Kidman"
    };

    String[] movieAns = {
            "d) Frank Darabont",
            "b) Forrest Gump",
            "a) Elijah Wood",
            "a) Leonardo DiCaprio",
            "c) The Matrix",
            "a) Tom Hanks",
            "a) X-wing Red 5",
            "b) Johnny Depp",
            "c) The Lion King",
            "a) Reese Witherspoon"
    };


    int qns=movieQuestions.length-1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mhome=findViewById(R.id.mbutn1);
        mnxt=findViewById(R.id.mbutn2);
        mqn=findViewById(R.id.movqn);
        m1=findViewById(R.id.mov1);
        m2=findViewById(R.id.mov2);
        m3=findViewById(R.id.mov3);
        m4=findViewById(R.id.mov4);
        mquesn=findViewById(R.id.mquestion);
        mopt1=findViewById(R.id.moption1);
        mopt2=findViewById(R.id.moption2);
        mopt3=findViewById(R.id.moption3);
        mopt4=findViewById(R.id.moption4);


        mquesn.setText(movieQuestions[mcrtqn]);
        mopt1.setText(movieOption1[mcrtqn]);
        mopt2.setText(movieOption2[mcrtqn]);
        mopt3.setText(movieOption3[mcrtqn]);
        mopt4.setText(movieOption4[mcrtqn]);



        mhome.setOnClickListener(this);
        mnxt.setOnClickListener(this);
        mquesn.setOnClickListener(this);
        mopt1.setOnClickListener(this);
        mopt2.setOnClickListener(this);
        mopt3.setOnClickListener(this);
        mopt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mbutn1) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (view.getId() == R.id.mbutn2) {
            if (mcrtqn == 3) {
                mnxt.setText("Submit");
            }
            if (moptselected) {
                if (mcrtqn < qns) {
                    mcrtqn++;
                    mopt2.setBackgroundColor(Color.CYAN);
                    mopt1.setBackgroundColor(Color.CYAN);
                    mopt3.setBackgroundColor(Color.CYAN);
                    mopt4.setBackgroundColor(Color.CYAN);

                    mquesn.setText(movieQuestions[mcrtqn]);
                    mopt1.setText(movieOption1[mcrtqn]);
                    mopt2.setText(movieOption2[mcrtqn]);
                    mopt3.setText(movieOption3[mcrtqn]);
                    mopt4.setText(movieOption4[mcrtqn]);

                    moptclicked=0;
                    moptselected = false;
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
        if (moptclicked==0) {
            if (view.getId() == R.id.moption1) {
                moptclicked++;
                moptselected = true;
                if (mopt1.getText().toString().equals(movieAns[mcrtqn])) {
                    mscore++;
                    mopt1.setBackgroundColor(Color.GREEN);
                } else {
                    mopt1.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.moption2) {
                moptclicked++;
                moptselected = true;
                if (mopt2.getText().toString().equals(movieAns[mcrtqn])) {
                    mscore++;
                    mopt2.setBackgroundColor(Color.GREEN);
                } else {
                    mopt2.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.moption3) {
                moptclicked++;
                moptselected = true;
                if (mopt3.getText().toString().equals(movieAns[mcrtqn])) {
                    mscore++;
                    mopt3.setBackgroundColor(Color.GREEN);
                } else {
                    mopt3.setBackgroundColor(Color.RED);
                }
            } else if (view.getId() == R.id.moption4) {
                moptclicked++;
                moptselected = true;
                if (mopt4.getText().toString().equals(movieAns[mcrtqn])) {
                    mscore++;
                    mopt4.setBackgroundColor(Color.GREEN);
                } else {
                    mopt4.setBackgroundColor(Color.RED);
                }
            }
        }
        SharedPreferences ref=getSharedPreferences("Score",MODE_PRIVATE);
        SharedPreferences.Editor ed=ref.edit();
        ed.putInt("Answer",mscore);
        ed.putInt("Question",10);
        ed.apply();
    }
}