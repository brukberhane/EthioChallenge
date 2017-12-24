package tech.asfaw.ethiochallenge.models;

import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private Random mRandom = new Random();

    public int getRandomInt(int size){
        return mRandom.nextInt(size);
    }

}
