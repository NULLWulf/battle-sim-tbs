package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ranged extends Units {

        public double rangedAttackPerModel;

        @JsonIgnore
        final static int directAttackRange = 3;
        @JsonIgnore
        final static int diagonalAttackRange = 2;

        public Ranged(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel, double rangedAttackPerModel) {
                super(faction, name, models, healthPerModel, defensePerModel, attackPerModel);
        }

        // needed for jackson handler
        public Ranged(){
        }

        public double getRangedAttack(){
                return this.rangedAttackPerModel * this.models;
        }
}
