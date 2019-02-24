package com.cx.designpatterns.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册模式 利用concurrentHashMap保证了全局单一
 * @author:wuming
 */
public class RegisterMap {

    private RegisterMap(){}

    private   static final Map<String, Object> map = new ConcurrentHashMap<>();

    public static RegisterMap getSingleton(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }

        if(map.get(name) == null){
            synchronized (RegisterMap.class){
                if(map.get(name) == null){
                    RegisterMap registerMap = new RegisterMap();
                    map.put(name, registerMap);
                    System.out.println(System.currentTimeMillis()+"结果:"+registerMap);
                }
            }
        }

        return (RegisterMap) map.get(name);
    }
}
