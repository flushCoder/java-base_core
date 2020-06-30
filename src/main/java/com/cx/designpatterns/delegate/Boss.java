package com.cx.designpatterns.delegate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuming
 * @date 2019/3/3 12:45
 */
public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.doing("开发");
        LinkedList<String> list = new LinkedList<>();
        list.add("123");
    }
}
