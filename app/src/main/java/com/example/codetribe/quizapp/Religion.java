package com.example.codetribe.quizapp;

import java.io.Serializable;

public class Religion implements Serializable
{

	private String[] mQuestion = {"In the beginning, God created the____and the_____.","How many days did God take for creation?","Who was the author of the Bible?","From where did Jesus start his ministry?","What did God call the firmament?"};

	private String[][] mOptions ={{"world,Man","Heaven,Earth","Adam,Eve"},{"5","6","7"},{"Holy Spirit Himself","Disciples Of Jesus","The Spirit of God Through 40 Authors"},{"Bethlehem","Nazareth","Galile"},{"Cloud","Earth","Heaven"}};
	
	private String[] mCorrectAnswers = {"Heaven,Earth","6","The Spirit of God Through 40 Authors","Galile","Heaven"};

    public String[] questions()
    {
        return mQuestion;
    }

    public String[][] options()
    {
        return mOptions;
    }


    public String getQuestion(int a)
	{
		String question = mQuestion[a];
		return question;	
	}
	
	public String getOption1(int a)
	{
		String option0 = mOptions[a][0];
		return option0;
	}
	
		public String getOption2(int a)
	{
		String option1 = mOptions[a][1];
		return option1;
	}
	
		public String getOption3(int a)
	{
		String option2 = mOptions[a][2];
		return option2;
	}
	
	public String getCorrectAnswer(int a)
	{
		String answer = mCorrectAnswers[a];
		return answer;
	}
}