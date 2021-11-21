package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Units {

    String faction; // faction unit belongs to
    String name;  // name of unit, mostly a flavor things

    // All values are loaded with initial, values change over the course of battle
    int models;  // number of people per unit
    double healthPerModel; // health per model
    @JsonIgnore  // calculated value ignored back Jackson
    double currentUnitHealth; // based models * health per models
    double defensePerModel; // inherent defense value per model
    double attackPerModel; // inherent attack value per model

    @JsonIgnore
    private int currentColumn;  // Map Grid Position System, in this instance columns
    @JsonIgnore
    private int currentRow;  // Map grid position system, in this instance rows

    @JsonIgnore
    final static int directAttackRange = 1;
    @JsonIgnore
    final static int diagonalAttackRange = 1;

    // Needed for Jackson handler
    public Units(){

    };

    // Generated Constructor
    public Units(String faction, String name, int models, double healthPerModel, double defensePerModel, double attackPerModel) {
        this.faction = faction;
        this.name = name;
        this.models = models;
        this.healthPerModel = healthPerModel;
        this.defensePerModel = defensePerModel;
        this.attackPerModel = attackPerModel;
        setCurrentUnitHealth();
    }

    public String getFaction() {
        return faction;
    }
    public void setFaction(String faction) {
        this.faction = faction;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getModels() {
        return models;
    }
    public void setModels(int models) {
        this.models = models;
    }
    public double getHealthPerModel() {
        return healthPerModel;
    }
    public void setHealthPerModel(double healthPerModel) {
        this.healthPerModel = healthPerModel;
    }
    public double getCurrentUnitHealth() {
        return currentUnitHealth;
    }
    public void setCurrentUnitHealth() {
        this.currentUnitHealth = this.models * this.healthPerModel;
    }
    public double getDefensePerModel() {
        return defensePerModel;
    }
    public void setDefensePerModel(double defensePerModel) {
        this.defensePerModel = defensePerModel;
    }
    public double getAttackPerModel() {
        return attackPerModel;
    }
    public void setAttackPerModel(double attackPerModel) {
        this.attackPerModel = attackPerModel;
    }
    public void removeModels(int remove) {this.models = this.models - remove;}
    public void setCurrentColumn(int x) {this.currentColumn = x;}  // Map Grid Position System, in this instance columns
    public void setCurrentRow(int y) {
        this.currentRow = y;
    }  // Map grid position system, in this instance rows
    public int getCurrentColumn() {
        return currentColumn;
    }  // Map Grid Position System, in this instance columns
    public int getCurrentRow() {
        return currentRow;
    }
    public int getDirectAttackRange() {return directAttackRange;}
    public int getDiagonalAttackRange() {return diagonalAttackRange;}

    public double calculateAttack(){ return this.attackPerModel * this.models;}
    public double calculateDefense() {return this.defensePerModel * this.models;}

}

