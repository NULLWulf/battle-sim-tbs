package com.army_builder;


import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.IOException;

public class ArmyBuilder {
        public static void main(String[] args) throws IOException {
            Graph<Object, DefaultEdge> simpleGraph = new SimpleGraph<>(DefaultEdge.class);
            simpleGraph.addVertex(50);
            simpleGraph.addVertex(25);
            simpleGraph.addVertex(30);
        }

    }
