package com.suiduo.lottery.ssq;

import java.util.ArrayList;
import java.util.List;

/*
* 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target
* */
public class LintCode2 {

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {15, 2, 7, 11};

        System.out.println(getList(arr1, 9));
        System.out.println(getList(arr2, 9));
    }

    public static List<Integer> getList(int[] arr, int target) {
        List<Integer> list = new ArrayList<Integer>();
        A:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    list.add(i);
                    list.add(j);
                    break A;
                }
            }
        }
        return list;
    }
}
