package com.army_builder;


import com.army_builder.models.*;
import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.JSON_Handler;
import com.army_builder.systems.Map;
import com.army_builder.systems.battle;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {

            battle BattleS = new battle();
            Ranged range = new Ranged("Array","Nathan",50,50,50,50,50);
            Infantry infantry = new Infantry("Hi","Hi",50,50,50,50);
            Cavalry cavalry = new Cavalry("Hi","Hi",50,50,50,50);
            //            Infantry infantry = new Infantry();
//            BattleS.unitWeakness(infantry,infantry);

            JSON_Handler json = new JSON_Handler();
            json.writeObjectAsJson("infantry.json",range);

//            Units[][] unitMap = new Units[4][4];
//
//            unitMap[0][0] = infantry;
//            unitMap[1][1] = range;

            Map map = new Map();
            map.generateMapBounds();
            map.displayUnitsOnMap();



        }

    }
