package com.cx.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * @author 南山
 * @date 2020/10/09 14:40
 */
public class TwoSumSolution {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ints);
    }

    /**
     * 解法1: 暴力解法 双重循环
     */
    /*public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0; i < length-1; i++){

            for(int j = i+1; j<length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }*/

    /**
     * 解法二
     * 一次循环,利用hash的数据结构特性,key为数组值,value为数组下标
     */
    /*public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int arr = target - nums[i];
            if(map.containsKey(arr)){
                return new int[]{map.get(arr), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }*/

    /**
     * 解法三: 用数组的值作为新数字的下标, 数组的下标作为新数组的值
     */
    public static int[] twoSum(int[] nums, int target) {
        int c = 2 << 10;
        int tem = c - 1;
        int[] arr = new int[c];
        for(int i = 0 ; i < nums.length; i++){
            int result = (target - nums[i]) & tem;
            if(arr[result] != 0){
                return new int[]{arr[result]-1, i};
            }
            arr[nums[i] & tem] = i + 1;
        }
        return new int[]{};

    }
}