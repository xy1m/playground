package com.xy1m.playground.guava.strings;

import com.google.common.base.CharMatcher;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class CharMatcherExplained {
    public static void main(String[] args) {
        String noControl = CharMatcher.javaIsoControl().removeFrom(""); // remove control characters
        System.out.println(noControl);
        String theDigits = CharMatcher.digit().retainFrom("1231231234uiwer123"); // only the digits
        System.out.println(theDigits);
        String spaced = CharMatcher.whitespace().trimAndCollapseFrom("  x  f   ", ' ');
        System.out.println(spaced);
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        String noDigits = CharMatcher.javaDigit().replaceFrom("123123hiui1238", "*"); // star out all digits
        System.out.println(noDigits);
        String lowerAndDigit = CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("QaUQ-*(&(1");
        // eliminate all characters that aren't digits or lowercase
        System.out.println(lowerAndDigit);

        System.out.println(CharMatcher.whitespace().removeFrom(" a  b "));
        System.out.println(CharMatcher.whitespace().retainFrom(" a  b "));
        System.out.println(CharMatcher.whitespace().trimFrom(" a  b "));
        System.out.println(CharMatcher.whitespace().replaceFrom(" a  b ", 'x'));
        System.out.println(CharMatcher.whitespace().collapseFrom("  a  b  ", ' '));
    }
}
