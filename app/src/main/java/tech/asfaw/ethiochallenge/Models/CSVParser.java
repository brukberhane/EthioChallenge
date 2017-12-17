package tech.asfaw.ethiochallenge.Models;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSVParser {

    private InputStream mInputStream;

    public CSVParser(InputStream inputStream){
        this.mInputStream = inputStream;
    }

    private List<Challenge> mChallenges;

    public List<Challenge> getChallengesFromCSV(){
        mChallenges = new ArrayList<>();
        List resultList = new ArrayList();
        String[] choicePool = {};

        BufferedReader reader = new BufferedReader(new InputStreamReader(mInputStream));

        try{
            String csvLine;

            while ((csvLine = reader.readLine()) != null){
                String[] row = csvLine.split(",");
                resultList.add(row);
            }
        } catch (IOException ioe){
            throw new RuntimeException("Error in reading CSV file: "+ioe);
        } finally{
            try{
                mInputStream.close();
            } catch (IOException ex){
                throw new RuntimeException("Error while closing InputStream: "+ex);
            }
        }

        for (int i=0; i < resultList.size(); i++){
            String[] stat = (String[]) resultList.get(i);
            Log.i("ጥያቄ： ", stat[0]);
            Log.i("መልስ： ", stat[1]);
            choicePool[i] = stat[1];
        }

        Random rand = new Random();
        for (int i=0; i < resultList.size(); i++){
            String[] stat = (String[]) resultList.get(i);
            String[] options = {stat[1]};
            options[1] = choicePool[rand.nextInt(resultList.size())];
            options[2] = choicePool[rand.nextInt(resultList.size())];
            options[3] = choicePool[rand.nextInt(resultList.size())];
            mChallenges.add(new Challenge(stat[0], options, 0));
        }

        return null;

    }

}
