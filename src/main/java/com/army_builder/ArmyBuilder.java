package com.army_builder;


import com.army_builder.models.*;
import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.JSON_Handler;
import com.army_builder.systems.battle;

import java.io.IOException;
import java.util.ArrayList;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {

            battle BattleS = new battle();
            Ranged range = new Ranged("Array","Nathan",50,50,50,50,50);
            Infantry infantry = new Infantry();
            BattleS.unitWeakness(infantry,infantry);
        }

    }
