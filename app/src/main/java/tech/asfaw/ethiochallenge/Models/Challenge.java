package tech.asfaw.ethiochallenge.Models;

public class Challenge {

    private String mQuestion;
    private String[] mOptions = new String[4];
    private int mAnswerLocation;

    public int getAnswerLocation() {
        return mAnswerLocation;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String[] getOptions() {
        return mOptions;
    }

    public Challenge(String question, String[] options, int answerLocation) {
        mQuestion = question;
        mOptions = options;
        mAnswerLocation = answerLocation;
    }

}
