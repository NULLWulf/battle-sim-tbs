package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cavalry extends Units {

    @JsonIgnore
    final static int directAttackRange = 3;
    @JsonIgnore
    final static int diagonalAttackRange = 2;



    public Cavalry(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        super(faction, name, models, healthPerModel, defensePerModel, attackPerModel);
    }

    // needed for Jackson handler
    public Cavalry(){


    }
}
