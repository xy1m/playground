package com.xy1m.playground.guava.basicutilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * Created by gzhenpeng on 2019/3/14
 */
public class NullExplained {

    public static void main(String[] args) {
        Optional oo = Optional.of(5);
        //Optional o0 = Optional.of(null);
        Optional o1 = Optional.absent();
        Optional o2 = Optional.fromNullable(null);
        Optional o3 = Optional.fromNullable(6);

        test(oo);
        //test(o0);
        test(o1);
        test(o2);
        test(o3);

        System.out.println(MoreObjects.firstNonNull(null, 1));
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.isNullOrEmpty(""));
        System.out.println(Strings.nullToEmpty(null));
    }

    public static void test(Optional optional) {
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println(optional.or(1));
        System.out.println(optional.orNull());
        System.out.println(optional.asSet());
    }
}
