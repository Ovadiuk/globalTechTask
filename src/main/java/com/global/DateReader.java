package com.global;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class DateReader{

    private String path;

    public DateReader(String path){
        this.path = path;
    }

    public JsonNode getJson(){
        try {
            return new ObjectMapper().readTree(new File(path));
        } catch (IOException e) {
            throw new RuntimeException("your file is inccorect"+e);
        }
    }
}