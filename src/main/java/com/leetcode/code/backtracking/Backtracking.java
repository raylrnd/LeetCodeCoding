package com.leetcode.code.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 阿里20.3.25笔试题第一题 （动态规划，类似于路径搜索思想）
 * 题目描述
 * 给定一个行数为3，列数为col的矩阵B，比如
 * 5 10 5 4 4
 * 1 7 8 4 0
 * 3 4 9 0 3
 * 从每一列中选择一个数，得到一个一行col列的一维数组，求该一维数组中每相邻两个数之差的绝对值的累加和的最小值
 * 比如这里就是5 7 5 4 4，所以输出是5
 *
 * 输入描述
 * 四行输入
 * 第一行输入为数组的列数n;
 * 第二至四行输入一个3*col的矩阵a,每行输入col个正整数。
 *
 * 输出描述
 * 一行一个正整数表示答案
 * 测试样例
 * 5
 * 5 10 5 4 4
 * 1 7 8 4 0
 * 3 4 9 0 3
 * @auther zhongshunchao
 * @date 09/07/2020 23:31
 */
public class Backtracking {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int col = in.nextInt();
        int[][] array = new int[3][col];
        //二维数组的输入
        for (int i = 0; i < 3; i++) {//此处i与j调换位置也会出错
            for (int j = 0; j < col; j++) {
                array[i][j] = in.nextInt();
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        dfs(array, 0, arrayList);
        System.out.println("Result " + result);
    }

//    private static void dfs(int[][] array, int j, ArrayList<Integer> arrayList) {
//
//        if (j == array[0].length) {
//            System.out.println("Bound");
//            System.out.println(arrayList);
//            return;
//        }
//        for (int i = 0; i < array.length; i++) {
//            int cur = array[i][j];
//            System.out.println("cur : " + cur);
//            arrayList.add(cur);
//            dfs(array, j + 1, arrayList);
//            arrayList.remove(arrayList.size() - 1);
//        }
//    }


    private static void dfs(int[][] array, int j, ArrayList<Integer> arrayList) {

        if (j == array[0].length) {
            System.out.println("Bound");
            System.out.println(arrayList);
            ArrayList<Integer> mycopy = new ArrayList<Integer>();
            mycopy=(ArrayList<Integer>) arrayList.clone();
            mycopy.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            System.out.println("sort" + mycopy);
            if (mycopy.size() == 1) {
                result = mycopy.get(0);
                return;
            }
            int midresult = 0;
            for (int i = 1; i < mycopy.size(); i++) {
                midresult += mycopy.get(i) - mycopy.get(i - 1);
                if (midresult > result) break;
            }
            if (midresult < result) {
                System.out.println("########################midresult " + midresult);
                result = midresult;
                System.out.println("########################resultArray" + mycopy + "," + arrayList);
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int cur = array[i][j];
            System.out.println("cur : " + cur);
            arrayList.add(cur);
            dfs(array, j + 1, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
