package com.example.codetribe.quizapp;

import java.io.Serializable;

public class Music implements Serializable
{
	private String[] mSport	 = {"SAMA Female Artist Of The Year 2017?","SAMA Male Artist Of The Year 2017?","R & B abbreviated one of the following?","Reggae, a style of popular music that originated in ____ in the late 1960's","____ is known as the queen of Gospel music"};

	private String[][] mSportOptions ={
			{"Lebo Sekgobela", "Babes Wodumo","Amanda Black"},
			{"Dr Tumi","Kwesta","Nasty C"},
			{"Rap and blue","Real and blues","Rhythm and blues"},
			{"South Africa","Jamaica","Columbia"},
			{"Rebecca Malope","Kholeka","Hlengiwe Mhlaba"}};
	
	private String[] mCorrectAnswers = {"Amanda Black","Kwesta","Rhythm and blues","Jamaica","Rebecca Malope"};
	
	public String getQuestion(int a)
	{
		String question = mSport[a];
		return question;	
	}
	
	public String getOption1(int a)
	{
		String option0 = mSportOptions[a][0];
		return option0;
	}
	
	public String getOption2(int a)
	{
		String option1 = mSportOptions[a][1];
		return option1;
	}
	
	public String getOption3(int a)
	{
		String option2 = mSportOptions[a][2];
		return option2;
	}
	
	public String getCorrectAnswer(int a)
	{
		String answer = mCorrectAnswers[a];
		return answer;
	}
}