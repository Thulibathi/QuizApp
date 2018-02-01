package com.example.codetribe.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private Button button;
    private String category;
    public static String POLITICS ="politics";
    public static String RELIGION ="religion";
    public static String MUSIC ="music";
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v)
    {
        switch(v.getId())
        {
            case R.id.button_politics:
                educationClick();
            break;
            case R.id.button_religion:
                religionClick();
                break;
            case R.id.button_music:
                musicClick();
                break;
        }

    }

    public void educationClick() {
        button = (Button) findViewById(R.id.button_politics);
        category = button.getText().toString();
        id = button.getId();
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra(POLITICS,category);
        intent.putExtra("number",id);
        startActivity(intent);
    }

    public void religionClick() {
        button = (Button) findViewById(R.id.button_religion);
        category = button.getText().toString();
        id = button.getId();
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra(RELIGION,category);
        intent.putExtra("number",id);
        startActivity(intent);
    }

    public void musicClick() {
        button = (Button) findViewById(R.id.button_music);
        category = button.getText().toString();
        id = button.getId();
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra(MUSIC, category);
        intent.putExtra("number",id);
        startActivity(intent);
    }
}
