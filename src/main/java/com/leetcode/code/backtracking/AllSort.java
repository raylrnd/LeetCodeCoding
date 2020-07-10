package com.leetcode.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @ https://leetcode-cn.com/problems/permutations/
 */
public class AllSort {
    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 20:22
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] hasVisited = new boolean[nums.length];
        backTracking(res, new ArrayList<>(), hasVisited, nums);
        return res;
    }

    /**
     * @param res
     * @param prefix
     * @param hasVisited
     * @param nums
     * @return void
     * @description 回溯法，排列数，不是子集树
     * @author WuBiao
     * @date 2020/3/22 20:22
     */
    private void backTracking(List<List<Integer>> res, List<Integer> prefix, boolean[] hasVisited, int[] nums) {
        if (prefix.size() == nums.length) {//找到结果把排列加到结果集中
            res.add(new ArrayList<>(prefix));//新建一个对象，如果不新建，prefix内容会被覆盖
            return;
        }
        for (int i = 0; i < hasVisited.length; i++) {//对每个没访问过的元素访问
            if (!hasVisited[i]) {
                prefix.add(nums[i]);
                hasVisited[i] = true;
                backTracking(res, prefix, hasVisited, nums);
                hasVisited[i] = false;//恢复现场
                prefix.remove(prefix.size() - 1);//恢复现场
            }
        }
    }
}
