package com.cx.utils.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序法
 * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class Charu {

    public static void main(String[] args){
        int[] arr = new int[]{9,6,5,8,7,0,1,2,3};
        int j;
        for(int i = 1;i<arr.length;i++){
            j = i;
            int temp = arr[i];
            while(j>0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(JSON.toJSONString(arr));
    }

}
