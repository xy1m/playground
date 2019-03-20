package com.xy1m.playground.guava.strings;

import com.google.common.base.CaseFormat;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class CaseFormatExplained {
    public static void main(String[] args) {
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "getFood"));
    }
}
