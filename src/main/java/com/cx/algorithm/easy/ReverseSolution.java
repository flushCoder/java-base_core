package com.cx.algorithm.easy;

/**
 * <p>
 *  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *  示例 1: 输入: 123  输出: 321
 *  示例 2: 输入: -123  输出: -321
 *  示例 3: 输入: 120   输出: 21
 *  注意:
 *
 *  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 * @author 南山
 * @date 2020/10/10 15:44
 */
public class ReverseSolution {

    public static void main(String[] args) {
        System.out.println(reverse(-52122));

    }

    /**
     * 暴力解法
     */
    /*public static int reverse(int x) {
        String s = String.valueOf(x);
        boolean flag = s.startsWith("-");
        if(flag){
            s = s.substring(1);
        }
        int length = s.length();
        char[] newString = new char[length];
        for(int i = 0; i < length/2; i++){
            char c = s.charAt(i);
            char d = s.charAt(length - 1 - i);
            newString[i] = d;
            newString[length - 1 - i] = c;
        }
        if(length % 2 == 1){
            newString[length/2] = s.charAt(length/2);
        }
        StringBuilder sb = new StringBuilder();
        if(flag){
            sb.append("-");
        }
        for(char ch : newString){
            sb.append(ch);
        }
        try {
            return Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }*/


    public static int reverse(int x) {

        return 0;
    }
}
