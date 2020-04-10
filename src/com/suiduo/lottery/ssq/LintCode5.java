package com.suiduo.lottery.ssq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LintCode5 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2019-12-31 23:59:59");
        System.out.println(date);
        //使用大写的"YYYY"会有问题
        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date2 = sdf2.parse("2019-12-31 23:59:59");
        System.out.println(date2);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = sdf3.parse("2020-01-01");
        System.out.println(date3);
        //使用大写的"YYYY"会有问题
        SimpleDateFormat sdf4 = new SimpleDateFormat("YYYY-MM-dd");
        Date date4 = sdf4.parse("2020-01-01");
        System.out.println(date4);
    }

}
