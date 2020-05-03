package com.xy1m.playground;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gzhenpeng on 2019-08-09
 */
public class ParseTTDVideo {

    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject wawa = gson.fromJson("{\n" +
                "    \"Columns\": [\n" +
                "        {\n" +
                "            \"ColumnName\": \"LogEntryTime\",\n" +
                "            \"Description\": \"The timestamp identifying when the impression occurred\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ImpressionId\",\n" +
                "            \"Description\": \"The unique identified of the impression associated with the video event\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventCreativeView\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the creative was displayed\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventStart\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video was started\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventFirstQuarter\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video played to the first quartile\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventMidpoint\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video played to the midpoint\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventThirdQuarter\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video played to the third quartile\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventComplete\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video played to completion\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventMute\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video was muted\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventUnmute\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video was unmuted\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CreativeIsTrackable\",\n" +
                "            \"Description\": \"true indicates that this is an event that fired when it was determined that the creative was trackable\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CreativeWasViewable\",\n" +
                "            \"Description\": \"true indicates that this is an event that fired when it was determined that the creative was viewable according to the partner's defined standard\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoPlayTimeInSeconds\",\n" +
                "            \"Description\": \"How far into the video did the video event occur\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoViewableTimeInSeconds\",\n" +
                "            \"Description\": \"For how many seconds has this video been viewable\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"VideoEventCompanionCreativeView\",\n" +
                "            \"Description\": \"1 indicates that this is an event that fired when the video's companion banner was displayed\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ProcessedTime\",\n" +
                "            \"Description\": \"The timestamp of when the log line was processed in REDS\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ImpressionPlacementId\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeclaredPlayerSize\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ActualPlayerSize\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdvertiserId\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"PostImpressionEventType\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}", JsonObject.class);

        JsonArray array = wawa.get("Columns").getAsJsonArray();
        Map<Integer, String> map = new HashMap<>();
        System.out.println("=====done=====");
        for (int i = 0; i < array.size(); i++) {
            JsonElement ele = array.get(i);
            map.put(i, ele.getAsJsonObject().get("ColumnName").getAsString());
            String columnName=ele.getAsJsonObject().get("ColumnName").getAsString();
            columnName=columnName.substring(0,1).toLowerCase()+columnName.substring(1);
            System.out.println("private String "+columnName+";");
        }
        System.out.println("=====done=====");
        Set<String> columns = Sets.newHashSet("ImpressionId", "Site", "MediaCostInBucks", "TTDCostInUSDollars");
        try {
            File f = new File("/Users/gzhenpeng/ttd1/videoevents_qaegfx8_V5_1_2019-08-08T010225_2019-08" +
                    "-08T010753_2019-08-08T014631_2973ef2b25b2cc410204d2945c00c067.log");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                String[] haha = readLine.split("\t");
                for (int i = 0; i < haha.length; i++) {
                    if(columns.contains(map.get(i))){
                        System.out.println("index=" + i + " column=" + map.get(i) + " value=" + haha[i] + ";");
                    }

                }
                System.out.println(readLine);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
