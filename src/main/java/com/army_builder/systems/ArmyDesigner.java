package com.army_builder.systems;


import com.army_builder.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class ArmyDesigner{

    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    Army dummyArmy = new Army();
    Infantry infantry;
    Cavalry cavalry;
    Ranged ranged;

    public void selectUnitToCreate() throws JsonProcessingException {

        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        do{
            int choice = validator.checkInt(1, 3, "select a unit to create");
            switch (choice) {
                case 1:
                    System.out.println("Entering Infantry Creation Menu");
                    infantry = designInfantryUnit();
                    dummyArmy.infantry.add(infantry);
                    break;
                case 2:
                    System.out.println("Entering Cavalry Creation Menu");
                    cavalry = designCavalryUnit();
                    dummyArmy.cavalry.add(cavalry);
                    break;
                case 3:
                    System.out.println("Entering Ranged Creation Menu");
                    ranged = designRangedUnit();
                    dummyArmy.ranged.add(ranged);
                    break;
            }
            System.out.println("Finished?");
            int choice2 = validator.checkInt(1,2," 1 for Yes, 2 for no");
            if(choice2 == 1){
                finished = true;
            }
        }while(!finished);

        JSON_Handler json = new JSON_Handler();
        json.displayObjectAsJson(dummyArmy);



    }

    public Ranged designRangedUnit() throws JsonProcessingException {

        System.out.println("Enter Data for the Unit. (Faction, Name, Models, Health, Defense, and Attack per Model");
        String faction = validator.checkIfString("Faction");
        String name = validator.checkIfString("Name");
        int models = validator.checkInt(50, 200, "Base Model Size");
        double healthPerModel = validator.checkInt(50, 200, "Base Health Per Model");
        double defensePerModel = validator.checkInt(50, 200, "Base Defense Per Model");
        double attackPerModel = validator.checkInt(50, 200, "Base Attack Per Model");

        Ranged ranged = new Ranged(faction, name, models, healthPerModel, defensePerModel, attackPerModel, 50);

        System.out.println("Selected Unit Stats");
        displayBaseStats(ranged);
        System.out.printf("Attack Per Model: %f\n", ranged.rangedAttackPerModel);

        return ranged;
    }
    public Cavalry designCavalryUnit() throws JsonProcessingException {

        System.out.println("Enter Data for the Unit. (Faction, Name, Models, Health, Defense, and Attack per Model");
        String faction = validator.checkIfString("Faction");
        String name = validator.checkIfString("Name");
        int models = validator.checkInt(50, 200, "Base Model Size");
        double healthPerModel = validator.checkInt(50, 200, "Base Health Per Model");
        double defensePerModel = validator.checkInt(50, 200, "Base Defense Per Model");
        double attackPerModel = validator.checkInt(50, 200, "Base Attack Per Model");

        Cavalry cavalry = new Cavalry(faction, name, models, healthPerModel, defensePerModel, attackPerModel);

        System.out.println("Selected Unit Stats");
        displayBaseStats(cavalry);

        return cavalry;
    }

    public Infantry designInfantryUnit() throws JsonProcessingException {

        System.out.println("Enter Data for the Unit. (Faction, Name, Models, Health, Defense, and Attack per Model");
        String faction = validator.checkIfString("Faction");
        String name = validator.checkIfString("Name");
        int models = validator.checkInt(50, 200, "Base Model Size");
        double healthPerModel = validator.checkInt(50, 200, "Base Health Per Model");
        double defensePerModel = validator.checkInt(50, 200, "Base Defense Per Model");
        double attackPerModel = validator.checkInt(50, 200, "Base Attack Per Model");

        Infantry infantry = new Infantry(faction, name, models, healthPerModel, defensePerModel, attackPerModel);

        System.out.println("Selected Unit Stats");
        displayBaseStats(infantry);

        return infantry;
    }

    public void displayBaseStats(Units unit){
        System.out.printf("Faction: %s\n",unit.getFaction());
        System.out.printf("Unit Name: %s\n",unit.getName());
        System.out.printf("Model Size: %d\n",unit.getModels());
        System.out.printf("Health Per Model: %f\n",unit.getHealthPerModel());
        System.out.printf("Defense Per Model: %f\n",unit.getDefensePerModel());
        System.out.printf("Attack Per Model: %f\n",unit.getAttackPerModel());
    }
}
