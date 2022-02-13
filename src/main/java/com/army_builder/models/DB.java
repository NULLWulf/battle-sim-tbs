package com.army_builder.models;

import com.army_builder.systems.Validator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.PrivateKey;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DB {


    @JsonProperty("documents")
    public ArrayList<Army> army = new ArrayList<>();

    public DB(){}

    public Army armyDbScroller(){

        int cursor = 0;  // variable to point to a place in the database to display
        int length = army.size()-1; // size of the db array list
        System.out.println(length + " armies currently saved to database.");

        boolean finished = false;

        Validator validator = new Validator();
        System.out.printf("Army %d of %d\n",cursor+1,length+1);
        army.get(cursor).armyOverview();
        do{
            int selection = validator.checkInt(1,3, """
                    one of the following:
                    1: Previous Army
                    2: Select Army to Download
                    3: Next Army
                    """);

            switch (selection) {
                case 1 ->{
                    if(cursor <= 0) {cursor = length;}
                    else{cursor--;}
                }
                case 2 ->{
                    finished = true;
                }
                case 3 ->{

                    if(cursor >= length){cursor = 0;}
                    else{cursor++;}
                }
            }

            System.out.printf("Army %d of %d\n",cursor+1,length+1);
            army.get(cursor).armyOverview();

        }while(!finished);

        return army.get(cursor);
    }
}
