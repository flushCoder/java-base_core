package com.cx.designpatterns.delegate;

/**
 * @author wuming
 * @date 2019/3/3 12:45
 */
public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.doing("开发");
    }
}
