package com.global.bdd.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.global.Main;
import com.global.Utils;
import cucumber.api.java8.En;
import org.junit.Assert;


public class StepDefs implements En {

    JsonNode jsonFile;
    Main main =new Main();

    public StepDefs(){
        Given("^User provides Path to jsonFile \"([^\"]*)\"$", (String path) -> {
            jsonFile = Utils.getJsonFile(path);
        });

        When ("^User Provides FieldName \"([^\"]*)\" after application should be find \"(\\d)\" Objects in this json file$",
                (String fieldName,Integer result)->{
            Assert.assertEquals((Integer) main.getCountFindObjectsInJsonFile(jsonFile,fieldName),result);
        });

        Then ("^User Provides FieldName \"([^\"]*)\" and Value \"([^\"]*)\" after application should be find \"(\\d)\" Objects in this json file$",
                (String fieldName,String value, Integer result)->{
            Assert.assertEquals((Integer) main.getCountFindObjectsInJsonFileWithValue(jsonFile,fieldName,value),result);
        });

    }
}
