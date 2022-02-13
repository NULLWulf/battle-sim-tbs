package com.army_builder;


import com.army_builder.models.*;
import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.Client;
import com.army_builder.systems.JSON_Handler;
import com.army_builder.systems.battle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {

            Infantry combatant1 = new Infantry("Elberterian Slayers",150,
                    75,50,200);
            Ranged combatant2 = new Ranged("Croszen Poinzers",150,
                    75,50,100,175);
            Cavalry combatant3 = new Cavalry("Joren Tumblers",50,
                    150,100,200);
            battle battle = new battle();
            battle.unit2unitAttack(combatant1,combatant2);

            ArmyDesigner armyDesigner = new ArmyDesigner();

            armyDesigner.selectUnitToCreate();



        }
    }
