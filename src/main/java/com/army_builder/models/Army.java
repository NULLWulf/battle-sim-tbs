package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Army {


    String _id;
    String faction; // Name of Army's Faction
    String factionLeader;


    public ArrayList<Units> units = new ArrayList<>();

    public Army(){}

    public Army(String faction){
        this._id = faction;
        this.faction = faction;
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
        this._id = factionLeader;
    }

    public void armyOverview() {
        System.out.printf("Faction Name: %s\n", faction);
        System.out.printf("Faction Leader: %s\n", factionLeader);
        System.out.printf("Infantry Units: %d\n", units.stream()
                .filter(i -> i.getClass() == Infantry.class)
                        .toArray()
                                .length);
        System.out.printf("Cavalry Units: %d\n", units.stream()
                .filter(i -> i.getClass() == Cavalry.class)
                .toArray()
                .length);
        System.out.printf("Ranged Units: %d\n", units.stream()
                .filter(i -> i.getClass() == Ranged.class)
                .toArray()
                .length);
    }
}
