package tech.asfaw.ethiochallenge.models;

import java.util.HashMap;

public class Person {

    private String mName;
    private int mQuestionsAnswered;
    private HashMap<Challenge, String> mChallengeResults;

    public HashMap<Challenge, String> getChallengeResults() {
        return mChallengeResults;
    }

    public void setChallengeResults(HashMap<Challenge, String> challengeResults) {
        mChallengeResults = challengeResults;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getQuestionsAnswered() {
        return mQuestionsAnswered;
    }

    public void setQuestionsAnswered(int questionsAnswered) {
        mQuestionsAnswered = questionsAnswered;
    }

    public Person(String name){
        mName = name;
    }

}
