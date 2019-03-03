package com.cx.designpatterns.delegate;

/**
 * @author wuming
 * @date 2019/3/3 12:47
 */
public class EmployeeOne implements Employee{
    @Override
    public void doing(String commend) {
        System.out.println("我擅长算法");
    }
}
