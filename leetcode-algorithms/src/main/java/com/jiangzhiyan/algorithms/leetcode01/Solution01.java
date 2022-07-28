package com.jiangzhiyan.algorithms.leetcode01;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和:
 * 给定一个整数数组nums和一个目标值target,
 * 请你在该数组中找出和为目标值的那两个整数,并返回他们的数组下标.
 * 你可以假设每种输入只会对应一个答案.
 * 但是,你不能重复利用这个数组中同样的元素.
 */
public class Solution01 {

    /**
     * 双层for循环
     */
    public static int[] solution01(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("无解!");
    }

    /**
     * 使用Map转为单层for循环
     */
    public static int[] solution02(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("无解!");
    }

    /**
     * 使用Bit结构
     */
    public static int[] solution03(int[] nums, int target){
        int volume = 2 << 14;//这个值是试出来的
        int bitMode = volume - 1;
        int[] t = new int[volume];
        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (t[c] != 0) {
                return new int[]{t[c] - 1, i};
            }
            t[nums[i] & bitMode] = i + 1;
        }
        throw new RuntimeException("无解!");
    }
}
