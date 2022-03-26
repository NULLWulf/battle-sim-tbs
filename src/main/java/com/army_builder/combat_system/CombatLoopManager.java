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

    ArrayList<Units> allUnits = new ArrayList<>();

    public CombatLoopManager(Army playerArmy, Army npcArmy) {
        this.playerArmy = playerArmy;
        this.npcArmy = npcArmy;

        allUnits.addAll(this.playerArmy.getUnits());
        allUnits.addAll(this.npcArmy.getUnits());

        Collections.sort(allUnits);
    }
}


