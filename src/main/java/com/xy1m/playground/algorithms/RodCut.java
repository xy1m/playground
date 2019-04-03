package com.xy1m.playground.algorithms;

import java.util.Arrays;

/**
 * Created by gzhenpeng on 2019/4/2
 */
public class RodCut {
    static int cutRecursive(int[] prices, int n) {
        if (n == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, prices[i] + cutRecursive(prices, n - i));
        }
        return res;
    }

    static int cutRodMemoized(int[] prices, int n) {
        int[] memo = new int[prices.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return cutRodMemoizedAux(prices, memo, n);
    }

    static int cutRodMemoizedAux(int[] prices, int[] memo, int n) {
        if (memo[n] >= 0) return memo[n];
        if (n == 0) return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, prices[i] + cutRecursive(prices, n - i));
        }
        memo[n] = res;
        return res;
    }

    static int cutRodBottomUp(int[] prices, int n) {
        int[] res = new int[prices.length];
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;

            for (int j = 1; j <= i; j++) {
                q = Math.max(q, prices[j] + res[i - j]);
            }
            res[i] = q;
        }
        return res[n];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cutRecursive(prices, 10));
        System.out.println(cutRodMemoized(prices, 10));
        System.out.println(cutRodBottomUp(prices, 10));
    }
}
