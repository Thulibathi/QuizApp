package com.example.codetribe.quizapp;

import java.io.Serializable;

public class Politics implements Serializable {
    private String[] mEducation = {"Who was the first president of South Africa?", "Who was the Prime Minister from 1978-1984? ", "Who became the first black president of South Africa?", "Nelson Mandela spent 27 years in ____ prison", "What was the ruling party before African National Congress(ANC)?"};

    private String[][] mEduOptions = {
            {"F.W Declerk", "Charles Robberts", "P.W Botha"},
            {"Pieter Willem Botha", "Marais Viljoen", "Balthazar Johannes Vorster"},
            {"Thabo Mbeki", "Nelson Rolihlahla Mandela", "Kgalema Motlanthe"},
            {"Drakenstein Correctional Centre", "Pollsmoor Prison", "Robbern Island"},
            {"Pan Africanist Congress(PAC)", "National Party(NP)", "Democratic Alliance(DA)"}};

    private String[] mCorrectAnswers = {"Charles Robberts", "Pieter Willem Botha", "Nelson Rolihlahla Mandela", "Robbern Island", "National Party(NP)"};

    public String getQuestion(int a) {
        String question = mEducation[a];
        return question;
    }

    public String getOption1(int a) {
        String option0 = mEduOptions[a][0];
        return option0;
    }

    public String getOption2(int a) {
        String option1 = mEduOptions[a][1];
        return option1;
    }

    public String getOption3(int a) {
        String option2 = mEduOptions[a][2];

        return option2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int numberOfQuestions() {
        return  mEducation.length;
    }
}