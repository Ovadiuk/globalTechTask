package com.global;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Utils {

    public static String readFile(String path)  {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("please repeat and write correct path"+e);
        }
        return sb.toString();
    }


    public static JsonNode getJsonFile (String path){
        try {
            return new ObjectMapper().readTree(Utils.readFile(path));
        } catch (IOException e) {
            throw new RuntimeException("your file is inccorect"+e);
        }
    }
}
