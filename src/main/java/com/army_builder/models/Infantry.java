package com.army_builder.models;

public class Infantry extends Units {
    public Infantry(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        super(faction, name, models, healthPerModel, defensePerModel, attackPerModel);
    }

    // needed for jackson handler
    public Infantry(){};
}
