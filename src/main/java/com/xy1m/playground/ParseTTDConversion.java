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
public class ParseTTDConversion {

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
                "            \"ColumnName\": \"ConversionId\",\n" +
                "            \"Description\": \"The unique id of the conversion as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdvertiserId\",\n" +
                "            \"Description\": \"The unique ID for the advertiser as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ConversionType\",\n" +
                "            \"Description\": \"The type of the conversion\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TDID\",\n" +
                "            \"Description\": \"The Trade Desk unique user identifier; the cookie ID\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"IPAddress\",\n" +
                "            \"Description\": \"The IP address of the device that provided the conversion\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ReferrerUrl\",\n" +
                "            \"Description\": \"The ReferrerUrl on the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MonetaryValue\",\n" +
                "            \"Description\": \"The value associated with the conversion\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MonetaryValueCurrency\",\n" +
                "            \"Description\": \"The currency of the monetary value\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"OrderId\",\n" +
                "            \"Description\": \"The unique identifier associated with a transaction/conversion event\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD1\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD2\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD3\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD4\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD5\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD6\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD7\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD8\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD9\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TD10\",\n" +
                "            \"Description\": \"Custom field that can be specified at conversion time, defined by advertiser/partner\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ProcessedTime\",\n" +
                "            \"Description\": \"The timestamp of when the log line was processed in REDS\",\n" +
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
            File f = new File("/Users/gzhenpeng/ttd1/conversions_qaegfx8_V5_1_2019-08-05T191734_2019-08-05T191734_2019-08-05T192839_fbba852ac9ab4a180440eb063ac13a03.log");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                String[] haha = readLine.split("\t");
                for (int i = 0; i < haha.length; i++) {
                        System.out.println("index=" + i + " column=" + map.get(i) + " value=" + haha[i] + ";");

                }
                System.out.println(readLine);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
