package com.global.bdd.steps;

import com.global.DateReader;
import com.global.NodeFinder;
import cucumber.api.java8.En;
import org.junit.Assert;


public class StepDefs implements En {

    NodeFinder nodeFinder;

    public StepDefs(){
        Given("^User provides Path to jsonFile \"([^\"]*)\"$", (String path) -> {
            nodeFinder = new NodeFinder(new DateReader(path).getJson());
        });

        When ("^User Provides FieldName \"([^\"]*)\" after application should be find \"(\\d)\" Objects in this json file$",
                (String fieldName,Integer result)->{
            Assert.assertEquals(result,(Integer) nodeFinder.getCountFindObjectsInJsonFile(fieldName));
        });

        Then ("^User Provides FieldName \"([^\"]*)\" and Value \"([^\"]*)\" after application should be find \"(\\d)\" Objects in this json file$",
                (String fieldName,String value, Integer result)->{
            Assert.assertEquals(result,(Integer) nodeFinder.getCountFindObjectsInJsonFileWithValue(fieldName,value));
        });

    }
}
