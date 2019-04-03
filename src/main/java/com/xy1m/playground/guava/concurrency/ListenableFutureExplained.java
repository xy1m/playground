package com.xy1m.playground.guava.concurrency;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class ListenableFutureExplained {
    public static void main(String[] args) {
        String campaignId="22245";
        System.out.println("select * " +
                " from ZEMANTA_CAMPAIGN as Cmp " +
                " left join LINE_ITEM li on Cmp.CAMPAIGN_ID = li.CAMPAIGN_ID " +
                " left join ZEMANTA_AD as ad on li.LINE_ITEM_ID = ad.LINE_ITEM_ID " +
                " where Cmp.CAMPAIGN_ID = " + campaignId +
                " and Cmp.ZEMANTA_CAMPAIGN_ID = (select min(ZEMANTA_CAMPAIGN_ID) " +
                " from ZEMANTA_CAMPAIGN where CAMPAIGN_ID = " + campaignId + ") " +
                " and (ad.STATUS != 'DELETED' or ad.STATUS is null) " +
                " and (li.LINE_ITEM_STATUS <> 'DELETED' or" +
                " li.LINE_ITEM_STATUS is null)" +
                " and li.CHANNEL_ID = 'ZEMANTA' " +
                " order by Cmp.ZEMANTA_CAMPAIGN_ID");
    }
}
