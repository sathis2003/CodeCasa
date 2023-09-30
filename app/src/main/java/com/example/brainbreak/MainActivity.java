package com.example.brainbreak;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView sci,genk,sport,techno,movie,ridd;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sci=findViewById(R.id.science);
        genk=findViewById(R.id.gk);
        sport=findViewById(R.id.sports);
        techno=findViewById(R.id.tech);
        movie=findViewById(R.id.movies);
        ridd=findViewById(R.id.riddle);

        sci.setOnClickListener(this);
        genk.setOnClickListener(this);
        sport.setOnClickListener(this);
        techno.setOnClickListener(this);
        movie.setOnClickListener(this);
        ridd.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
        ad.setTitle("EXIT");
        ad.setMessage("Do You Want to exit?");
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        ad.show();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.science)
        {
            Intent in=new Intent(MainActivity.this,Science.class);
            startActivity(in);
        }
        if(view.getId()==R.id.gk)
        {
            Intent in=new Intent(MainActivity.this,Gk.class);
            startActivity(in);
        }
        if(view.getId()==R.id.sports)
        {
            Intent in=new Intent(MainActivity.this,Sports.class);
            startActivity(in);
        }
        if(view.getId()==R.id.riddle)
        {
            Intent in=new Intent(MainActivity.this,Riddle.class);
            startActivity(in);
        }
        if(view.getId()==R.id.tech)
        {
            Intent in=new Intent(MainActivity.this,Technology.class);
            startActivity(in);
        }
        if(view.getId()==R.id.movies)
        {
            Intent in=new Intent(MainActivity.this,Movies.class);
            startActivity(in);
        }
    }
}