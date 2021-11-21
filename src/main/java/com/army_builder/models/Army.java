package com.army_builder.models;

import java.util.ArrayList;

public class Army {

    String faction; // Name of Army's Faction
    String factionLeader;

    public ArrayList<Cavalry> cavalry = new ArrayList<>();
    public ArrayList<Ranged> ranged = new ArrayList<>();
    public ArrayList<Infantry> infantry = new ArrayList<>();

    public Army(){

    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getFactionLeader() {
        return factionLeader;
    }

    public void setFactionLeader(String factionLeader) {
        this.factionLeader = factionLeader;
    }
}
