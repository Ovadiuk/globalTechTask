package com.global;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args){
        NodeFinder nodeFinder;
        if (args.length <2){
            System.out.println("Please write Path & field name & value");
        }else if (args.length == 2){
            nodeFinder = new NodeFinder(new DateReader(args[0]).getJson());
            System.out.println("found " +nodeFinder.getCountFindObjectsInJsonFile(args[1]) + " objects with field "+ args[1]);
        }else {
            nodeFinder = new NodeFinder(new DateReader(args[0]).getJson());
            System.out.println("found " +nodeFinder.getCountFindObjectsInJsonFile(args[1]) + " objects with field "+args[1]);
            System.out.println("found " +nodeFinder.getCountFindObjectsInJsonFileWithValue(args[1],args[2]) + " where "+args[1] +" equals "+ args[2]);
        }
    }
}
