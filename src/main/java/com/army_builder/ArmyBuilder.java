package com.army_builder;


import com.army_builder.systems.ArmyDesigner;
import com.army_builder.systems.Client;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {
            ArmyDesigner armyDesigner = new ArmyDesigner ();
            armyDesigner.selectUnitToCreate();
        }

    }
