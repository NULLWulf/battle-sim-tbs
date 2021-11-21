package com.army_builder.systems;

import com.army_builder.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JSON_Handler {

    ObjectMapper objectMapper = new ObjectMapper();


    // simply returns passed object as formatted JSON string
    public String getObjAsJSONString(Object object) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
    public void displayObjectAsJson(Object object) throws JsonProcessingException {
        System.out.println(this.getObjAsJSONString(object));
    }

    // Writes passed object as JSON file based on it's specified path and passed object
    public void writeObjectAsJson(String path,Object object) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get(path).toFile(),object);
    }

    // Specific Function for returning army saved as JSON file
    public Army getArmyJson(String path) throws IOException {

        return objectMapper.readValue(new File(path), Army.class);

    }

}
