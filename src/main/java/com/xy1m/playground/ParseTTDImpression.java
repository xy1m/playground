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
public class ParseTTDImpression {

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
                "            \"Description\": \"The unique identifier associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"PartnerId\",\n" +
                "            \"Description\": \"The unique ID for the partner as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdvertiserId\",\n" +
                "            \"Description\": \"The unique ID for the advertiser as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CampaignId\",\n" +
                "            \"Description\": \"The unique ID for the campaign as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdGroupId\",\n" +
                "            \"Description\": \"The unique ID for the ad group as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"PrivateContractId\",\n" +
                "            \"Description\": \"The ID of a group of deal IDs that was used to bid on this impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AudienceId\",\n" +
                "            \"Description\": \"The unique ID for the audienceas assigned by TTD. An Audience is made up of one or more data groups\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CreativeId\",\n" +
                "            \"Description\": \"The unique ID for the creative as assigned by TTD\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdFormat\",\n" +
                "            \"Description\": \"The size of the served creative. Expressed as height x width\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Frequency\",\n" +
                "            \"Description\": \"The count of the impression served to a user within the defined frequency slope\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"SupplyVendor\",\n" +
                "            \"Description\": \"The supply vendor from which the impression was purchased\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"SupplyVendorPublisherId\",\n" +
                "            \"Description\": \"The unique ID for the publisher from which the impression was purchased\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DealId\",\n" +
                "            \"Description\": \"The deal ID used to buy a given impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Site\",\n" +
                "            \"Description\": \"The domain or app where the impression was purchased and displayed\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ReferrerCategories\",\n" +
                "            \"Description\": \"A comma separated list of site category IDsfromThe Trade Desk universal taxonomy\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MatchedFoldPosition\",\n" +
                "            \"Description\": \"The declared position of the ad.  Possible values: Above(2), Below(3), Unknown(4)\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"UserHourOfWeek\",\n" +
                "            \"Description\": \"The hour of the week from the user’s timezone in which the impression took place. Possible values are between 0 and 167\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"UserAgent\",\n" +
                "            \"Description\": \"A software agent that is acting on behalf of a user. It is often aweb browser telling a web site information about the browser and operating system\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"IPAddress\",\n" +
                "            \"Description\": \"The IP address of the device that received the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TDID\",\n" +
                "            \"Description\": \"The Trade Desk unique user identifier; the cookie ID\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"CountryLong\",\n" +
                "            \"Description\": \"The country associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Region\",\n" +
                "            \"Description\": \"Region within a country where the impression was served.  Could be a state, province, county or other region\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Metro\",\n" +
                "            \"Description\": \"The ID of thethe metropolitanareaassociated with the impression event\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"City\",\n" +
                "            \"Description\": \"The city where the impression was served\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeviceType\",\n" +
                "            \"Description\": \"The numeric identifier oftype of device on which the impression was served\",\n" +
                "            \"Facet\": \"DeviceTypes\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"OSFamily\",\n" +
                "            \"Description\": \"The numeric identifier of the Operating System family associated with the impression\",\n" +
                "            \"Facet\": \"OSFamilies\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"OS\",\n" +
                "            \"Description\": \"The numeric identifier of the Operating System version associated with the impression\",\n" +
                "            \"Facet\": \"OSes\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Browser\",\n" +
                "            \"Description\": \"The numeric identifier of the browser associated with the impression\",\n" +
                "            \"Facet\": \"Browsers\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Recency\",\n" +
                "            \"Description\": \"The number of minutes since the user was seen on the targeted data element\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MatchedLanguageCode\",\n" +
                "            \"Description\": \"The targeted language that matched the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"MediaCostInBucks\",\n" +
                "            \"Description\": \"The cost of impression in US Dollars\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"FeeFeaturesCost\",\n" +
                "            \"Description\": \"The cost of our additional TTD Features\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DataUsageTotalCost\",\n" +
                "            \"Description\": \"The cost of 3rd Party data\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TTDCostInUSDollars\",\n" +
                "            \"Description\": \"The sum of Media Cost and Data Cost\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"PartnerCostInUSDollars\",\n" +
                "            \"Description\": \"The sum of TTD Cost, Fee FeaturesCost & Platform Fee\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"AdvertiserCostInUSDollars\",\n" +
                "            \"Description\": \"The sum of PartnerCostInUSD and PartnerMarkUp (If tracked in our platform)\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Latitude\",\n" +
                "            \"Description\": \"The latitude associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Longitude\",\n" +
                "            \"Description\": \"The longitude associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeviceAdvertisingId\",\n" +
                "            \"Description\": \"The unique identifier at the device-level (i.e. IDFA or Android ID)\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Zip\",\n" +
                "            \"Description\": \"The zipcode associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"ProcessedTime\",\n" +
                "            \"Description\": \"The timestamp of when the log line was processed in REDS\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeviceMake\",\n" +
                "            \"Description\": \"The make of the device associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"DeviceModel\",\n" +
                "            \"Description\": \"The model of the device associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"RenderingContext\",\n" +
                "            \"Description\": \"The environment where an ad creative loads\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"Carrier\",\n" +
                "            \"Description\": \"The CarrierId of the device associated with the impression\",\n" +
                "            \"Facet\": \"MobileCarriers\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TemperatureInCelsius\",\n" +
                "            \"Description\": \"The approximate temperature in the location associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TemperatureBucketStartInCelsius\",\n" +
                "            \"Description\": \"Starting value of temperature range in the location associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"TemperatureBucketEndInCelsius\",\n" +
                "            \"Description\": \"Ending value of temperature range in the location associated with the impression\",\n" +
                "            \"Facet\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"ColumnName\": \"PredictiveClearingBidAmountCpmInUsd\",\n" +
                "            \"Description\": null,\n" +
                "            \"Facet\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}", JsonObject.class);

        JsonArray array = wawa.get("Columns").getAsJsonArray();
        Map<Integer, String> map = new HashMap<>();
        System.out.println("=====begin=====");
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
            File f = new File("/Users/gzhenpeng/ttd1/impressions_qaegfx8_V5_1_2019-08-08T000050_2019-08" +
                    "-08T000050_2019-08-08T000646_065de62f6f99ac017f7ac7d8fb0c861e.log");
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
