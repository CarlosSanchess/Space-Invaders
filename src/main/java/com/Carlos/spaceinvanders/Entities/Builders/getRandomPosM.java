package com.Carlos.spaceinvanders.Entities.Builders;

import com.Carlos.spaceinvanders.Entities.positionModel;

import java.util.Random;

public class getRandomPosM {
   public static positionModel positionModel() {
       long seed = System.currentTimeMillis();
       Random random = new Random(seed);
       int randomNumber = random.nextInt(79) + 1;
       return new positionModel(randomNumber, 2);
   }
}
