package com.army_builder.combat_system;

import com.army_builder.models.Army;
import com.army_builder.models.Units;

import java.util.LinkedList;
import java.util.Queue;

public class Main_System {

    Army playerArmy;
    Army npcArmy;

    Queue<Units> turnQueue = new LinkedList<Units>();

    public Main_System(Army playerArmy, Army npcArmy){

        playerArmy = this.playerArmy;
        npcArmy = this.npcArmy;
    }

    public Main_System(){}

    public void initializeTurnQueue(){

    }
}

