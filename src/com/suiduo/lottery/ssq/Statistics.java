package com.suiduo.lottery.ssq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Statistics {
    public static void main(String[] args) throws Exception {
        demo();
    }

    public static String demo() throws Exception {
        File file = new File(Statistics.class.getClassLoader().getResource("resource/ssq.txt").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String[]> baseList = new ArrayList<String[]>();
        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null) {
            if (count > 1000) {
                break;
            }
            //System.out.println(line.substring(0, 33));
            //System.out.println(line.substring(19, 33));
            String substring = line.substring(19, 33);

            //if ("06091127282907".equals(substring)) {
            //    System.out.println("这个号码出现过了！");
            //}
            //if ("01071420263212".equals(substring)) {
            //    System.out.println("这个号码出现过了！");
            //}

            //String[] arr = new String[]{substring};
            String[] arr = new String[]{
                    substring.substring(0, 2)
                    ,
                    substring.substring(2, 4)
                    ,
                    substring.substring(4, 6)
                    ,
                    substring.substring(6, 8)
                    ,
                    substring.substring(8, 10)
                    ,
                    substring.substring(10, 12)
                    //,
                    //substring.substring(12, 14)
            };
            baseList.add(arr);
            count++;
        }

        //求出组合数字出现的次数
        HashMap<String, Long> comboMap = new HashMap<>();
        for (int i = 0; i < baseList.size(); i++) {
            String[] arr = baseList.get(i);
            for (int j = 0; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    String combo = arr[j] + arr[k];
                    if (comboMap.containsKey(combo)) {
                        comboMap.put(combo, comboMap.get(combo) + 1);
                    } else {
                        comboMap.put(combo, 1L);
                    }

                    //for (int l = k + 1; l < arr.length; l++) {
                    //    String combo = arr[j] + arr[k] + arr[l];
                    //    if (comboMap.containsKey(combo)) {
                    //        comboMap.put(combo, comboMap.get(combo) + 1);
                    //    } else {
                    //        comboMap.put(combo, 1L);
                    //    }
                    //}
                }
            }
        }
        //按出现次数排序
        List<Map.Entry<String, Long>> comboCountList = new ArrayList<Map.Entry<String, Long>>(comboMap.entrySet());
        Collections.sort(comboCountList, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println("统计每组数字出现的次数：");
        for (int i = 0; i < comboCountList.size(); i++) {
            Map.Entry<String, Long> entry = comboCountList.get(i);
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("******************************************************");
        for (int i = 0; i < comboCountList.size(); i++) {
            Map.Entry<String, Long> entry = comboCountList.get(i);
            //if (entry.getKey().contains("31")) {
            //    System.out.println(entry.getKey() + "\t" + entry.getValue());
            //}
            if (entry.getKey().endsWith("16")) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }
        System.out.println("******************************************************");

        if (true) return null;

        //求出每行的和
        List<Long> sumList = new ArrayList<Long>();
        for (int i = 0; i < baseList.size(); i++) {
            String[] arr = baseList.get(i);
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += Long.parseLong(arr[j]);
            }
            sumList.add(sum);
        }
        //统计每个和出现的次数
        Map<Long, Long> sumCountMap = new HashMap<Long, Long>();
        for (int i = 0; i < sumList.size(); i++) {
            Long num = sumList.get(i);
            if (sumCountMap.containsKey(num)) {
                sumCountMap.put(num, sumCountMap.get(num) + 1);
            } else {
                sumCountMap.put(num, 1L);
            }
        }
        //按出现次数排序
        List<Map.Entry<Long, Long>> sumCountList = new ArrayList<Map.Entry<Long, Long>>(sumCountMap.entrySet());
        Collections.sort(sumCountList, new Comparator<Map.Entry<Long, Long>>() {
            @Override
            public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println("统计每行的和出现的次数：");
        for (int i = 0; i < sumCountList.size(); i++) {
            Map.Entry<Long, Long> entry = sumCountList.get(i);
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        //统计每个数字出现的次数
        Map<String, Long> numCountMap = new HashMap<String, Long>();
        for (int i = 0; i < baseList.size(); i++) {
            String[] arr = baseList.get(i);
            for (int j = 0; j < arr.length; j++) {
                String num = arr[j];
                if (numCountMap.containsKey(num)) {
                    numCountMap.put(num, numCountMap.get(num) + 1);
                } else {
                    numCountMap.put(num, 1L);
                }
            }
        }
        //按出现次数排序
        List<Map.Entry<String, Long>> numCountList = new ArrayList<Map.Entry<String, Long>>(numCountMap.entrySet());
        Collections.sort(numCountList, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println("统计每个数字出现的次数：");
        for (int i = 0; i < numCountList.size(); i++) {
            Map.Entry<String, Long> entry = numCountList.get(i);
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        return null;
    }
}