package com.xy1m.playground.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gzhenpeng on 2019/4/17
 */
public class TreeModel {
    public static void main(String[] args) {
        //Create an JsonParser instance
/*        JsonParser parser = new JsonParser();

        String jsonString =
                "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        //create tree from JSON
        JsonElement rootNode = parser.parse(jsonString);
        System.out.println(rootNode);*/

        JsonParser parser = new JsonParser();
        String jsonString =
                "[{\"id\":\"1\",\"name\":\"english\"},{\"id\":\"2\",\"name\":\"spanish\"},{\"id\":\"3\",\"name\":\"chinese\"},{\"id\":\"4\",\"name\":\"german\"},{\"id\":\"5\",\"name\":\"french\"},{\"id\":\"6\",\"name\":\"hindi\"},{\"id\":\"7\",\"name\":\"arabic\"},{\"id\":\"8\",\"name\":\"portuguese\"},{\"id\":\"9\",\"name\":\"russian\"},{\"id\":\"10\",\"name\":\"bengali\"},{\"id\":\"11\",\"name\":\"japanese\"},{\"id\":\"12\",\"name\":\"dutch\"},{\"id\":\"13\",\"name\":\"italian\"},{\"id\":\"14\",\"name\":\"swedish\"},{\"id\":\"15\",\"name\":\"danish\"},{\"id\":\"16\",\"name\":\"malay\"},{\"id\":\"17\",\"name\":\"romanian\"},{\"id\":\"18\",\"name\":\"indonesian\"},{\"id\":\"19\",\"name\":\"slovak\"},{\"id\":\"20\",\"name\":\"bulgarian\"},{\"id\":\"21\",\"name\":\"hebrew\"},{\"id\":\"22\",\"name\":\"tagalog/Filipino\"},{\"id\":\"23\",\"name\":\"tamil\"},{\"id\":\"24\",\"name\":\"albanian\"},{\"id\":\"25\",\"name\":\"armenian\"},{\"id\":\"26\",\"name\":\"turkish\"},{\"id\":\"27\",\"name\":\"nepali\"},{\"id\":\"28\",\"name\":\"polish\"},{\"id\":\"29\",\"name\":\"thai\"},{\"id\":\"30\",\"name\":\"swiss\"},{\"id\":\"31\",\"name\":\"korean\"},{\"id\":\"32\",\"name\":\"greek\"},{\"id\":\"33\",\"name\":\"norwegian\"},{\"id\":\"34\",\"name\":\"finnish\"},{\"id\":\"35\",\"name\":\"ukrainian\"},{\"id\":\"36\",\"name\":\"czech\"},{\"id\":\"37\",\"name\":\"vietnamese\"},{\"id\":\"38\",\"name\":\"icelandic\"},{\"id\":\"39\",\"name\":\"urdu\"},{\"id\":\"40\",\"name\":\"hungarian\"},{\"id\":\"41\",\"name\":\"croatian\"},{\"id\":\"42\",\"name\":\"telugu\"}]";
        //create tree from JSON
        JsonElement rootNode = parser.parse(jsonString);
        JsonArray array = rootNode.getAsJsonArray();
        List<String> list=new ArrayList<>();
        for (JsonElement jsonElement : array) {
            list.add(jsonElement.getAsJsonObject().get("name").getAsString());
        }
        System.out.println(list);
    }
}
