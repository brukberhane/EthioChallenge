package tech.asfaw.ethiochallenge.models;

public class Person {

    private String mName;
    private int mQuestionsAnswered;
//    private HashMap<Challenge, String> mChallengeResults;
    private int mCorrect;
    private int mWrong;

    public int getCorrect() {
        return mCorrect;
    }

    public Person setCorrect(int correct) {
        mCorrect = correct;
        return this;
    }

    public int getWrong() {
        return mWrong;
    }

    public Person setWrong(int wrong) {
        mWrong = wrong;
        return this;
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
