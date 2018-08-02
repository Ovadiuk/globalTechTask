package com.global;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args)throws IOException{
        Main main = new Main();
        if (args.length <2){
            System.out.println("Please write Path & field name & value");
        }else if (args.length == 2){
            JsonNode jsonFile = Utils.getJsonFile(args[0]);
            System.out.println("found " +main.getCountFindObjectsInJsonFile(jsonFile,args[1]) + " objects with field "+ args[1]);
        }else if (args.length > 2) {
            JsonNode jsonFile = Utils.getJsonFile(args[0]);
            System.out.println("found " +main.getCountFindObjectsInJsonFile(jsonFile,args[1]) + " objects with field "+args[1]);
            System.out.println("found " +main.getCountFindObjectsInJsonFileWithValue(jsonFile,args[1],args[2]) + " where "+args[1] +" equals "+ args[2]);
        }
    }

    public int getCountFindObjectsInJsonFile(JsonNode jsonFile, String fieldName){
        return jsonFile.findValues(fieldName).size();
    }

    public int getCountFindObjectsInJsonFileWithValue(JsonNode jsonFile, String fieldName, String value){
        int countObjectEqualsToValue = 0;
        List<JsonNode> fieldsWithValue = jsonFile.findValues(fieldName);
        for (JsonNode jn: fieldsWithValue){
            if (jn.asText().equals(value))
                countObjectEqualsToValue++;
        }
        return countObjectEqualsToValue;
    }
}
