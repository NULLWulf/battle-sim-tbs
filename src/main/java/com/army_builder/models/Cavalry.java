package com.army_builder.models;

public class Cavalry extends Units {


    public Cavalry(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        super(faction, name, models, healthPerModel, defensePerModel, attackPerModel);
    }

    // needed for Jackson handler
    public Cavalry(){

    }
}
