package tech.asfaw.ethiochallenge.models;

public class Person {

    private String mName;
    private int mQuestionsAnswered;

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
