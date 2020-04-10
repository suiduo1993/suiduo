package com.suiduo.lottery.ssq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
* 找到指定位数内所有的水仙花数
* */
public class LintCode1 {

    public static void main(String[] args) {
        long p = getMaxNum(4);
        System.out.println(p);

        int q = getCalcNum(2, 5);
        System.out.println(q);

        List<Integer> l = getList(456789);
        System.out.println(l);

        int n = 5;
        long start = System.currentTimeMillis();
        System.out.println(getSxhNum(n));
        long end = System.currentTimeMillis();
        System.out.println("耗时" + new BigDecimal(end - start).divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP).toString() + "秒");
    }

    /*
    * 获取指定位数内所有的水仙花数
    * */
    public static List<Integer> getSxhNum(int length) {
        List<Integer> list = new ArrayList<Integer>();
        long min = getMaxNum(length - 1);
        long max = getMaxNum(length);
        for (int i = (int) (min + 1); i >= min && i <= max; i++) {
            List<Integer> l = getList(i);
            int sum = 0;
            for (int j = 0; j < l.size(); j++) {
                Integer n = l.get(j);
                int calcNum = getCalcNum(n, String.valueOf(i).length());
                sum += calcNum;
            }
            if (i == sum) {
                list.add(i);
            }
        }
        return list;
    }

    /*
    * 获取指定位数的最大值
    * */
    public static long getMaxNum(int length) {
        String str = "1";
        for (int i = 0; i < length; i++) {
            str += "0";
        }
        long n = Long.parseLong(str) - 1;
        return n;
    }

    /*
    * 获取指定数字指定幂数的值
    * */
    public static int getCalcNum(int n, int count) {
        int a = n;
        for (int i = 1; i < count; i++) {
            n = n * a;
        }
        return n;
    }

    /*
    * 获取指定数字的集合
    * */
    public static List<Integer> getList(int n) {
        String str = String.valueOf(n);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i, i + 1);
            list.add(Integer.parseInt(substr));
        }
        return list;
    }
}
