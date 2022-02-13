package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ranged extends Units {

        public double rangedAttackPerModel;

        @JsonIgnore
        final static int directAttackRange = 3;
        @JsonIgnore
        final static int diagonalAttackRange = 2;

        public Ranged(String name, int models, double healthPerModel, double defensePerModel, double attackPerModel, double rangedAttackPerModel) {
                super(name, models, healthPerModel, defensePerModel, attackPerModel);
        }

        // needed for jackson handler
        public Ranged(){
        }

        public double getRangedAttack(){
                return this.rangedAttackPerModel * this.models;
        }
}
