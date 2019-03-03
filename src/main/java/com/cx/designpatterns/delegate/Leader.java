package com.cx.designpatterns.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 委派模式:
 * 将任务几种分发,专业人做专业事
 * 
 * @author wuming
 * @date 2019/3/3 12:46
 */
public class Leader implements Employee{

    Map<String, Employee> map = new HashMap<>();

    public Leader(){
        map.put("算法", new EmployeeOne());
        map.put("开发", new EmployeeTwo());
    }

    @Override
    public void doing(String commend) {
        map.get(commend).doing(commend);
    }
}
