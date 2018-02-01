package com.example.codetribe.quizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private TextView scoreTv;
    private int score = 0;
    private ArrayList<String> answers ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        scoreTv= (TextView) findViewById(R.id.score_view);
        Intent intent = getIntent();
        score = intent.getIntExtra("score",0);
        answers=intent.getStringArrayListExtra("list");
        scoreTv.setText(String.valueOf(score));
    }

    public void resultDialog(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder((ResultActivity.this));
        builder.setMessage(String.valueOf(answers))
                .setTitle("Answers")
                .setCancelable(false)
                .setPositiveButton("Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
        .setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }
}
