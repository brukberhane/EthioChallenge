package tech.asfaw.ethiochallenge.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

import tech.asfaw.ethiochallenge.R;

import static android.content.Context.MODE_PRIVATE;

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
