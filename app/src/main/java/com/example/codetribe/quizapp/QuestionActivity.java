package com.example.codetribe.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    //view declaration
    private ImageView topicImageView;
    private TextView questionTextView;
    private RadioButton radA;
    private RadioButton radB;
    private RadioButton radC;
    private RadioGroup answers_group;

    private Toolbar toolbar;

    //variable declaration
    private String topic;
    private String answer = "";
    private String userChoice;
    private String question;
    private int score = 0;
    private int questionNumber = 0;
    private ArrayList<String> userChoices = new ArrayList<String>();
    private ArrayList<String> finalResults = new ArrayList<String>();

    //Object declaration
    private Music music = new Music();
    private Religion religion = new Religion();
    private Politics politics = new Politics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        topicImageView = (ImageView) findViewById(R.id.bgheader);
        questionTextView = (TextView) findViewById(R.id.text_view_question);
        answers_group = (RadioGroup) findViewById(R.id.answers_group);

        radA = (RadioButton) findViewById(R.id.radio_one);
        radB = (RadioButton) findViewById(R.id.radio_two);
        radC = (RadioButton) findViewById(R.id.radio_three);

        updateQuestion();

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //This method allow the user to select the possible answer
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_one:
                if (checked)
                    if (radA.getText() == answer) {

                        score = score + 1;
                        updateQuestion();
                        Toast.makeText(QuestionActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuestionActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }

                break;
            case R.id.radio_two:
                if (checked)
                    if (radB.getText() == answer) {
                        score = score + 1;
                        updateQuestion();
                        Toast.makeText(QuestionActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuestionActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }

                break;
            case R.id.radio_three:
                if (checked)
                    if (radC.getText() == answer) {
                        score = score + 1;
                        updateQuestion();

                        Toast.makeText(QuestionActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuestionActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }

                break;
        }
    }

    public void politics() {
        Intent intent = getIntent();

        topic = intent.getStringExtra(MainActivity.POLITICS);
        question = politics.getQuestion(questionNumber);

        toolbar.setTitle(topic);
        topicImageView.setImageResource(R.drawable.pol);
        questionTextView.setText(question);
        radA.setText(politics.getOption1(questionNumber));
        radB.setText(politics.getOption2(questionNumber));
        radC.setText(politics.getOption3(questionNumber));

        answer = politics.getCorrectAnswer(questionNumber);
        if (radA.getText() == politics.getOption1(questionNumber)) {
            userChoices.add(radA.getText().toString());
        } else if (radB.getText() == politics.getOption2(questionNumber)) {
            userChoices.add(radB.getText().toString());
        } else if (radC.getText() == politics.getOption3(questionNumber)) {
            userChoices.add(radC.getText().toString());
        }
        userChoice = userChoices.get(questionNumber);
        finalResults.add(question + "\n\nYour answer: " + userChoice + "\n\nCorrect answer: " + answer+"\n\n");
        questionNumber++;

    }

    public void religion() {
        Intent intent = getIntent();

        topic = intent.getStringExtra(MainActivity.RELIGION);
        question = religion.getQuestion(questionNumber);

        toolbar.setTitle(topic);
        topicImageView.setImageResource(R.drawable.bible);
        questionTextView.setText(question);
        radA.setText(religion.getOption1(questionNumber));
        radB.setText(religion.getOption2(questionNumber));
        radC.setText(religion.getOption3(questionNumber));

        answer = religion.getCorrectAnswer(questionNumber);
        if (radA.getText() == religion.getOption1(questionNumber)) {
            userChoices.add(radA.getText().toString());
        } else if (radB.getText() == religion.getOption2(questionNumber)) {
            userChoices.add(radB.getText().toString());
        } else if (radC.getText() == religion.getOption3(questionNumber)) {
            userChoices.add(radC.getText().toString());
        }
        userChoice = userChoices.get(questionNumber);
        finalResults.add(""+question + "\n\nYour answer: " + userChoice + "\n\nCorrect answer: " + answer+"\n\n");
        questionNumber++;
    }

    public void music() {
        Intent intent = getIntent();

        topic = intent.getStringExtra(MainActivity.MUSIC);
        question = music.getQuestion(questionNumber);

        toolbar.setTitle(topic);
        topicImageView.setImageResource(R.drawable.music_pic);
        questionTextView.setText(question);
        radA.setText(music.getOption1(questionNumber));
        radB.setText(music.getOption2(questionNumber));
        radC.setText(music.getOption3(questionNumber));

        answer = music.getCorrectAnswer(questionNumber);
        if (radA.getText() == music.getOption1(questionNumber)) {
            userChoices.add(radA.getText().toString());
        } else if (radB.getText() == music.getOption2(questionNumber)) {
            userChoices.add(radB.getText().toString());
        } else if (radC.getText() == music.getOption3(questionNumber)) {
            userChoices.add(radC.getText().toString());
        }
        userChoice = userChoices.get(questionNumber);
        finalResults.add(question + "\n\nYour answer: " + userChoice + "\n\nCorrect answer: " + answer);
        questionNumber++;

    }

    public void updateQuestion() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("number", 0);
        answers_group.clearCheck();
        if (id == R.id.button_politics) {
            if (questionNumber < politics.numberOfQuestions()) {
                politics();
            } else {
                result();
            }
        } else if (id == R.id.button_religion) {
            if (questionNumber < politics.numberOfQuestions()) {
                religion();
            } else {
                result();
            }
        } else if (id == R.id.button_music) {
            if (questionNumber < politics.numberOfQuestions()) {
                music();
            } else {
                result();
            }
        }

    }

    public void result() {
        Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putStringArrayListExtra("list", finalResults);
        startActivity(intent);
    }
}