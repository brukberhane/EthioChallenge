package tech.asfaw.ethiochallenge.models;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private String mQuestion;
    private List<String> mOptions = new ArrayList<>();
    private int mAnswerLocation;

    public int getAnswerLocation() {
        return mAnswerLocation;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getOptions() {
        return mOptions;
    }

    public Challenge(String question, List<String> options, int answerLocation) {
        mQuestion = question;
        mOptions = options;
        mAnswerLocation = answerLocation;
    }

}