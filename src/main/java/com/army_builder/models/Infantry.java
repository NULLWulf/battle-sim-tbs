package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Infantry extends Units {

    @JsonIgnore
    final static int directAttackRange = 1;
    @JsonIgnore
    final static int diagonalAttackRange = 1;
    @JsonIgnore
    public int currentModels;

    @JsonIgnore
    Queue<Integer> rankFile = new LinkedList<Integer>();


    public Infantry(String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        super(name, models, healthPerModel, defensePerModel, attackPerModel);
        rankFileGenerator();
    }

    // needed for jackson handler
    public Infantry(){

    }

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

    public void iterateOverFile(){

        // hasNext() returns true if the queue has more elements
        for (Integer integer : rankFile) {
            // next() returns the next element in the iteration
            System.out.print(integer);
            System.out.print("  ");
        }
        System.out.println("  ");

    }

    public double calculateAttack(){
        int rank1Models = rankFile.element(); // Get number of models in first 1st rank at time
        rankFile.remove(); // remove
        rankFile.add(rank1Models); // and place at back
        int rank2Models = rankFile.element(); // Get  next rank model count (this rank stays in place)
        return (rank2Models + rank1Models) * this.getAttackPerModel(); // final calculated value based on
    }

    public void damageRank(int modelsToLose){
        int rank1Models = rankFile.element(); // Get number of models in first 1st rank at time
        rankFile.remove(); // remove
        rankFile.add(rank1Models); // and place at back

    }

    public void reformRanks(){

        int currentModels = 0;
        for (Integer integer : rankFile) {
            // next() returns the next element in the iteration
            currentModels += rankFile.element();
        }
        double currentModelProportion = Double.parseDouble(String.valueOf(currentModels/this.getModels()));

        if(currentModelProportion < .50){
            this.rankFileGenerator();
        }
    }
}
