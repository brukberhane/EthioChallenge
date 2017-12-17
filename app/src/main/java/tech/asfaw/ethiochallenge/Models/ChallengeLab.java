package tech.asfaw.ethiochallenge.Models;

import android.content.Context;

import java.io.InputStream;
import java.util.List;

import tech.asfaw.ethiochallenge.R;

public class ChallengeLab {

    private Context mContext;
    private List<Challenge> mChallenges;

    public ChallengeLab(Context context){
        mContext = context.getApplicationContext();
    }

    public List<Challenge> getChallenges(){
        InputStream inputStream = mContext.getResources().openRawResource(R.raw.examples);
        CSVParser csvParser = new CSVParser(inputStream);
        return mChallenges = csvParser.getChallengesFromCSV();
    }

}
