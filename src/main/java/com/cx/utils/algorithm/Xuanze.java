package com.cx.utils.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 * 1、从待排序序列中，找到关键字最小的元素
 * 2、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
 * 3、从余下的 N - 1 个元素中，找出关键字最小的元素，重复1、2步，直到排序结束
 */
public class Xuanze {
    public static void main(String[] args){
        int[] arr = new int[]{9,6,5,8,7,0,1,2,3};
        for(int i = 0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++ ){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            System.out.println("第"+(i+1)+"次运行："+JSON.toJSONString(arr));
        }
        System.out.println(JSON.toJSONString(arr));
    }
}
