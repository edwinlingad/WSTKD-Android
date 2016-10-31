package com.ascensive_software.wstkd.core;

import java.util.Date;
import java.util.Random;

/**
 * Created by edwin on 10/28/16.
 */

public class RandomNumberGenerator {

    private Random random;

    public RandomNumberGenerator() {
        random = new Random(new Date().getTime());
    }

    public int generateRandomNumber(int max){
        return random.nextInt(max);
    }
}
