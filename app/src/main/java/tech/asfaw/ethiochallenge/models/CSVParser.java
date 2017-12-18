package tech.asfaw.ethiochallenge.models;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CSVParser {

    private InputStream mInputStream;

    CSVParser(InputStream inputStream){
        this.mInputStream = inputStream;
    }

    private List<Challenge> mChallenges;

    List<Challenge> getChallengesFromCSV(){
        mChallenges = new ArrayList<>();
        List resultList = new ArrayList();
        List choicePool = new ArrayList();

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
            choicePool.add(stat[1]);
        }

        Random rand = new Random();
        for (int i=0; i < resultList.size(); i++){
            String[] stat = (String[]) resultList.get(i);
            String[] options = {stat[1]};
            choicePool.remove(stat[1]);
            int ch1 = rand.nextInt(resultList.size());
            options[1] = (String) choicePool.get(ch1);
            choicePool.remove(ch1);
            int ch2 = rand.nextInt(resultList.size());
            options[2] = (String) choicePool.get(ch2);
            choicePool.remove(ch2);
            int ch3 = rand.nextInt(resultList.size());
            options[3] = (String) choicePool.get(ch3);
            choicePool.remove(ch2);
            mChallenges.add(new Challenge(stat[0], options, 0));
        }

        return mChallenges;

    }

}
