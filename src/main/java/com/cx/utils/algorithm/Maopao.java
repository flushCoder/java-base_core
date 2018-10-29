package com.cx.utils.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序法
 */
public class Maopao {

    public static void main(String[] args){
        //int[] arr = new int[]{9,6,5,8,7,0,1,2,3};
        int[] arr = new int[]{8,7,6,5,4,3,2,1,0};
        for(int i = 0;i<arr.length;i++){
            //flag初始化为true 如果数组为最终结果直接退出
            boolean flag = true;
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            System.out.println("flag="+flag);
            System.out.println("为："+JSON.toJSONString(arr));
            if(flag){
                break;
            }
            System.out.println("排序："+(i+1));
        }
        System.out.println(JSON.toJSON(arr));
    }
}
