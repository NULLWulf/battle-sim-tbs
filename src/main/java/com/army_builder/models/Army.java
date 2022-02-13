package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Army {

    String _id;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void armyOverview() {
        System.out.printf("Faction Name: %s\n", faction);
        System.out.printf("Faction Leader: %s\n", factionLeader);
        System.out.printf("Infantry Units: %d\n", infantry.size());
        System.out.printf("Cavalry Units: %d\n", cavalry.size());
        System.out.printf("Ranged Units: %d\n", ranged.size());
    }
}
