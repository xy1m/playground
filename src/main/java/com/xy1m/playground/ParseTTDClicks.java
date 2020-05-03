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
public class ParseTTDClicks {

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
                "            \"ColumnName\": \"ClickRedirectId\",\n" +
                "            \"Description\": \"The unique id of the conversion as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"IPAddress\",\n" +
                "            \"Description\": \"The IP address of the device where the click originated\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ReferrerUrl\",\n" +
                "            \"Description\": \"The address of the webpage that is linked to the click request\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"RedirectUrl\",\n" +
                "            \"Description\": \"The address of the webpage(s) that a click redirects through before arriving at the landing page\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CampaignId\",\n" +
                "            \"Description\": \"The unique ID for the campaign as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ChannelId\",\n" +
                "            \"Description\": \"The channel from which the click was recorded. Used to record clicks from sources outside of RTB\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdvertiserId\",\n" +
                "            \"Description\": \"The unique ID for the advertiser as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DisplayImpressionId\",\n" +
                "            \"Description\": \"The unique identifier associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Keyword\",\n" +
                "            \"Description\": \"A particular word or phrase that describes the content surrounding the click event\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"KeywordId\",\n" +
                "            \"Description\": \"The unique identifier associated with the keyword\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MatchType\",\n" +
                "            \"Description\": \"The matchtype determines how closely an input matches your keyword\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DistributionNetwork\",\n" +
                "            \"Description\": \"A client defined field used to identify the source of a non-display click\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TDID\",\n" +
                "            \"Description\": \"The Trade Desk unique user identifier; the cookie ID\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"RawUrl\",\n" +
                "            \"Description\": \"The full URL that was received to track the click.  This can be used to extract custom parameters\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ProcessedTime\",\n" +
                "            \"Description\": \"The timestamp of when the log line was processed in REDS\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeviceAdvertisingId\",\n" +
                "            \"Description\": \"The unique identifier at the device-level (i.e. IDFA or Android ID)\",\n" +
                "            \"Facet\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}", JsonObject.class);

        JsonArray array = wawa.get("Columns").getAsJsonArray();
        Map<Integer, String> map = new HashMap<>();
        System.out.println("===============");
        for (int i = 0; i < array.size(); i++) {
            JsonElement ele = array.get(i);
            map.put(i, ele.getAsJsonObject().get("ColumnName").getAsString());
            String columnName=ele.getAsJsonObject().get("ColumnName").getAsString();
            columnName=columnName.substring(0,1).toLowerCase()+columnName.substring(1);
            System.out.println("private String "+columnName+";");
        }
        System.out.println("===============");
        Set<String> columns = Sets.newHashSet("ImpressionId", "Site", "MediaCostInBucks", "TTDCostInUSDollars");
        try {
            File f = new File("/Users/gzhenpeng/ttd1/clicks_qaegfx8_V5_1_2019-08-08T105844_2019-08-08T105844_2019-08-08T110816_a25ebdef1de2336b820dd867464c72ab.log");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
                String[] haha = readLine.split("\t");
                for (int i = 0; i < haha.length; i++) {
                        System.out.println("index=" + i + " column=" + map.get(i) + " value=" + haha[i] + ";");

                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
