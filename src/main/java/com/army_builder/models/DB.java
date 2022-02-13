package com.army_builder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.PrivateKey;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DB {


    @JsonProperty("documents")
    public ArrayList<Army> army = new ArrayList<>();

    public DB(){

    }

}
