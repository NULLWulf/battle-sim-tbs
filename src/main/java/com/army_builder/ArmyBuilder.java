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

            Infantry infantry = new Infantry("Burners","Clerics",278,50,50,50);

            for(int i = 0; i < 100; i ++){
                infantry.damageFrontRank();
            }
        }

    }
