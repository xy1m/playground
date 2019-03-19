package com.xy1m.playground.guava.basicutilities;

import com.google.common.base.Preconditions;

/**
 * Created by gzhenpeng on 2019/3/14
 */
public class PredictionExplained {
    public static void main(String[] args) {
        Preconditions.checkArgument(false, "argument is invalid");
        Preconditions.checkNotNull(null, "argument is null");
        Preconditions.checkState(false, "argument state wrong");
        Preconditions.checkElementIndex(5, 5, "index wrong");
        Preconditions.checkPositionIndex(5, 5, "position wrong");
        Preconditions.checkPositionIndexes(3, 6, 5);
    }
}
