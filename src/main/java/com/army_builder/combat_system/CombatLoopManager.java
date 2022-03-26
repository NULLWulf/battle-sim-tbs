package com.army_builder.combat_system;

import com.army_builder.models.Army;
import com.army_builder.models.Units;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CombatLoopManager {

    Army playerArmy;
    Army npcArmy;

    ArrayList<Units> allUnits;

    Queue<Units> battleQue;

    public CombatLoopManager(Army playerArmy, Army npcArmy) {  // Primary constructor

        this.playerArmy = playerArmy;  // References playerArmy object here
        this.npcArmy = npcArmy;         // References Npc Army object here

        allUnits = new ArrayList<>();  // initialize arraylist

        allUnits.addAll(this.playerArmy.getUnits());  // add all playerArmy units to ArrayList
        allUnits.addAll(this.npcArmy.getUnits()); // add all npcArmy units to ArrayList

        Collections.sort(allUnits);  // sorts units by Speed, with the fastest units going first

        battleQue.addAll(allUnits);  // After sorts adds all units to Queue


    }
}


