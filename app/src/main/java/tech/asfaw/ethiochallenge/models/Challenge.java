package tech.asfaw.ethiochallenge.models;

import java.util.ArrayList;
import java.util.List;

public class Challenge {

    private String mQuestion;
    private List<String> mOptions = new ArrayList<>();
    private String mAnswer;

    public String getAnswer() {
        return mAnswer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getOptions() {
        return mOptions;
    }

    public Challenge(String question, List<String> options, String answer) {
        mQuestion = question;
        mOptions = options;
        mAnswer = answer;
    }

}