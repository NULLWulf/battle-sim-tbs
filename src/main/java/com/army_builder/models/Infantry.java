package com.army_builder.models;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Infantry extends Units {

    final static int directAttackRange = 1;
    final static int diagonalAttackRange = 1;

    Queue<Integer> rankFile = new LinkedList<Integer>();


    public Infantry(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        super(faction, name, models, healthPerModel, defensePerModel, attackPerModel);
        rankFileGenerator();
    }

    // needed for jackson handler
    public Infantry(){

    };

    private void rankFileGenerator(){

        int modelsToSplit = this.getModels();  // get number of models
        int linesOfTwenty = modelsToSplit / 20; // # of lines of 20 models
        int remainderOfModels = modelsToSplit % 20; // remainder of models after # of lines of 20 models

        // Remaining Model unit is first added to queue
        rankFile.add(remainderOfModels);
        // Remaining Models follow in
        for(int i = 1; i <= linesOfTwenty; i++){
            rankFile.add(20);
        }
    }

    public void damageFrontRank(){

        int modelsInFile = rankFile.element();  // Gets models in current rank

        int modelsToLose = ThreadLocalRandom.current().nextInt(5, 9 + 1);

        modelsInFile = modelsInFile - modelsToLose;  // subtracts passed models to lose
        rankFile.remove(); // removes current model file
        rankFile.add(modelsInFile); // add back in damaged models d

        iterateOverFIle();

    }

    public void iterateOverFIle(){

        // hasNext() returns true if the queue has more elements
        for (Integer integer : rankFile) {
            // next() returns the next element in the iteration
            System.out.print(integer);
            System.out.print("  ");
        }
        System.out.println("  ");

    }

}
