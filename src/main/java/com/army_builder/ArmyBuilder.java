package com.army_builder;

import com.army_builder.models.*;
import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.Client;
import com.army_builder.systems.JSON_Handler;
import com.army_builder.systems.battle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.C;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {
//            ArmyDesigner armyDesigner = new ArmyDesigner();
//
//            armyDesigner.selectUnitToCreate();

            Client client = new Client();
            System.out.println(client.findAll());
            JSON_Handler json_handler = new JSON_Handler();
            ObjectMapper mapper = new ObjectMapper();
            DB db = new DB();
            db = mapper.readValue(client.findAll(), DB.class);
            db.armyDbScroller();

        }
    }
