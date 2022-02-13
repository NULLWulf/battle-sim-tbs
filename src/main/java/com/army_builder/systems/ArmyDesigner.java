package com.army_builder.systems;
import com.army_builder.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.checkerframework.common.reflection.qual.NewInstance;

import java.io.IOException;
import java.util.Scanner;
public class ArmyDesigner{
    Scanner scanner = new Scanner(System.in);
    Validator validator = new Validator();
    Army dummyArmy = new Army();
    Infantry infantry;
    Cavalry cavalry;
    Ranged ranged;

    public void selectUnitToCreate() throws IOException {

        Scanner scanner = new Scanner(System.in);
        dummyArmy.setFaction(validator.checkIfString("faction"));
        dummyArmy.setFactionLeader(validator.checkIfString("faction leader"));
        boolean finished = false;
        designUnit();
//        do{
//            String selection = "\n1: Infantry\n" +
//                    "2: Cavalry \n3: Ranged \n";
//            int choice = validator.checkInt(1, 3, selection);
//            switch (choice) {
//                case 1 -> {
//                    System.out.println("Entering Infantry Creation Menu");
//                    infantry = designInfantryUnit();
//                    dummyArmy.infantry.add(infantry);
//                }
//                case 2 -> {
//                    System.out.println("Entering Cavalry Creation Menu");
//                    cavalry = designCavalryUnit();
//                    dummyArmy.cavalry.add(cavalry);
//                }
//                case 3 -> {
//                    System.out.println("Entering Ranged Creation Menu");
//                    ranged = designRangedUnit();
//                    dummyArmy.ranged.add(ranged);
//                }
//            }
//            System.out.println("Finished?");
//            int choice2 = validator.checkInt(1,2," 1 for Yes, 2 for no");
//            if(choice2 == 1){
//                finished = true;
//            }
//        }while(!finished);

        String customerJSONFile = dummyArmy.getFaction() + ".json";
        JSON_Handler json = new JSON_Handler();
        json.displayObjectAsJson(dummyArmy);

//        System.out.printf("Saving file as %s.json \n",customerJSONFile);
//
//        json.writeObjectAsJson(customerJSONFile,  dummyArmy);
//
//        System.out.println("Testing custom json faction file writer");
//        Army testArmy = json.getArmyJson(customerJSONFile);
//        json.displayObjectAsJson(dummyArmy);

        Client send = new Client();
        send.insertOneArmy(json.getObjAsJSONString(dummyArmy));
    }

    public void designUnit() throws JsonProcessingException {

        System.out.println("Select which type of unit you wish to create ");
        int unitTypeSelection = validator.checkInt(1, 3, """
                 a selection
                1: Infantry
                2: Cavalry
                3: Ranged
                """);

        String name = validator.checkIfString("Name");
        int models = validator.checkInt(1, 10, "Base Model Size");
        int healthPerModel = validator.checkInt(1, 10, "Base Health Per Model");
        int defensePerModel = validator.checkInt(1, 10, "Base Defense Per Model");
        int attackPerModel = validator.checkInt(1, 10, "Base Attack Per Model");

        switch (unitTypeSelection){
            case 1 -> { // Infantry Selection
                dummyArmy.infantry.add(new Infantry(name,models,healthPerModel,defensePerModel,attackPerModel));
            }
            case 2 -> { // Cavalry Selection
                dummyArmy.cavalry.add(new Cavalry(name,models,healthPerModel,defensePerModel,attackPerModel));
            }
            case 3 -> {  // Ranged Selection
                int rangedAttackPerModel = validator.checkInt(1, 10, "Ranged Attack Per Model");
                dummyArmy.ranged.add(new Ranged(name,models,healthPerModel,defensePerModel,attackPerModel,rangedAttackPerModel));
            }
        }
    }


    public void displayBaseStats(Units unit){
        System.out.printf("Unit Name: %s\n",unit.getName());
        System.out.printf("Model Size: %d\n",unit.getModels());
        System.out.printf("Health Per Model: %f\n",unit.getHealthPerModel());
        System.out.printf("Defense Per Model: %f\n",unit.getDefensePerModel());
        System.out.printf("Attack Per Model: %f\n",unit.getAttackPerModel());
        if(unit.getClass() == Ranged.class){
            System.out.printf("Attack Per Model: %f\n",((Ranged) unit).getRangedAttack());
        }
    }

    public void displayUnitSlct(){
        System.out.println();
    }
}
