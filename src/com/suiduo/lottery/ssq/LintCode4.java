package com.suiduo.lottery.ssq;

public class LintCode4 {

    public static void main(String[] args) {
        long m = 20;
        long n = factorial(m);
        System.out.println(n);
        System.out.println(getZeroCount(n));
        System.out.println("****************************************************************");
        int a = 9 << 3;
        System.out.println(a);
    }

    public static int getZeroCount(long n) {
        StringBuffer sb = new StringBuffer(String.valueOf(n)).reverse();
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if ("0".equals(sb.substring(i, i + 1))) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static long factorial(long n) {
        if (n > 1) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }
}
