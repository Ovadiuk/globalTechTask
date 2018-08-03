package com.global;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;

public class NodeFinder {

    private JsonNode jsonFile;

    public NodeFinder (JsonNode jsonNode){
        this.jsonFile =jsonNode;
    }

    private int getCountFindObjects(JsonNode file, String fieldName, String value) {
        if(file==null) return 0;

        int res=0;
        Iterator<Map.Entry<String, JsonNode>> fields = file.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> child =  fields.next();
            String key = child.getKey();
            JsonNode val = child.getValue();

            if(value==null && key.equals(fieldName)) res++;

            if(key.equals(fieldName) && val.asText().equals(value)){
                res++;
            }else if(val.isArray()){
                for (JsonNode node : val) {
                    res+=getCountFindObjects(node, fieldName, value);
                }

            }else{
                res+=getCountFindObjects(val, fieldName, value);
            }
        }
        return res;
    }

    public int getCountFindObjectsInJsonFileWithValue (String fieldName, String value ){
        return getCountFindObjects(jsonFile,fieldName,value);
    }

    public int getCountFindObjectsInJsonFile (String fieldName){
        return getCountFindObjects(jsonFile,fieldName,null);
    }
}