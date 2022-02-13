package com.army_builder;


import com.army_builder.models.Army;
import com.army_builder.models.DB;
import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.Client;
import com.army_builder.systems.JSON_Handler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {
            Client client = new Client();
            String results = client.findAll();
            JSON_Handler jsonHandler = new JSON_Handler();
            ObjectMapper objectMapper = new ObjectMapper();
            DB db = objectMapper.readValue(results, DB.class);

            ArmyDesigner armyDesigner = new ArmyDesigner();
            armyDesigner.selectUnitToCreate();
        }

    }
