package com.suiduo.lottery.ssq;

/*
* 给出 2 * n + 1个数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字
* */
public class LintCode3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 4, 4};
        int[] arr2 = {0, 0, 1};

        System.out.println(getNum(arr1));
        System.out.println(getNum(arr2));

        int o = 3;
        int p = 3;
        int q = 4;
        int n = o + p + q;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toOctalString(n));
        System.out.println(Integer.toHexString(n));

        System.out.println(getSum(4, 5));
    }

    /*
    * 通过异或，相同的数结果为0，那么最后的结果一定是落单的数字
    * */
    public static Integer getNum(int[] arr) {
        int rst = 0;
        for (int i = 0; i < arr.length; i++) {
            rst ^= arr[i];
        }
        return rst;
    }

    /*
    * 不适用“+”运算符计算两个数的和
    * */
    public static int getSum(int a, int b) {
        if ((a & b) == 0)
            return a | b;
        return getSum(a ^ b, (a & b) << 1);
    }
}
