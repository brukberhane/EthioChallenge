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

    List<Challenge> getChallengesFromCSV(){
        List<String[]> listofArrays = getListofRows();
        List<String> choicePool = populateChoicePool(listofArrays);

        return createChallenges(listofArrays, choicePool);
    }

    private List<Challenge> createChallenges(List<String[]> listofArrays, List<String> choicePool) {
        List<Challenge> challenges = new ArrayList<>();
        RandomGenerator randGen = new RandomGenerator();
        for (int i = 0; i < listofArrays.size(); i++){
            String[] stat = listofArrays.get(i);
            List<String> tempChoicePool = new ArrayList<>(choicePool);
            List<String> options = new ArrayList<>();
            options.add(stat[1]);
            tempChoicePool.remove(stat[1]);
            int ch1 = randGen.getRandomInt(tempChoicePool.size());
            Log.i("1 ችግር： ", String.valueOf(ch1));
            options.add(tempChoicePool.get(ch1));
            tempChoicePool.remove(ch1);
            int ch2 = randGen.getRandomInt(tempChoicePool.size());
            Log.i("2 ችግር： ", String.valueOf(ch2));
            options.add(tempChoicePool.get(ch2));
            tempChoicePool.remove(ch2);
            int ch3 = randGen.getRandomInt(tempChoicePool.size());
            Log.i("3 ችግር： ", String.valueOf(ch3));
            options.add(tempChoicePool.get(ch3));
            tempChoicePool.remove(ch3);
            challenges.add(new Challenge(stat[0], options, options.get(0)));
        }
        return challenges;
    }

    private List<String> populateChoicePool(List<String[]> listofArrays) {
        List<String> choicePool = new ArrayList<>();

        for (int i = 0; i < listofArrays.size(); i++){
            String[] stat = listofArrays.get(i);
            Log.i("ጥያቄ： ", stat[0]);
            Log.i("መልስ： ", stat[1]);
            choicePool.add(stat[1]);
        }

        return choicePool;
    }

    private List<String[]> getListofRows() {
        List<String[]> resultList = new ArrayList<>();

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
                //noinspection ThrowFromFinallyBlock
                throw new RuntimeException("Error while closing InputStream: "+ex);
            }
        }

        return resultList;
    }

}
