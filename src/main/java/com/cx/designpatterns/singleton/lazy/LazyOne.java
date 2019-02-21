package com.cx.designpatterns.singleton.lazy;

/**
 * 懒汉式
 * @author:wuming
 */
public class LazyOne {

    private LazyOne(){};

    private static LazyOne lazyOne = null;

    public static synchronized LazyOne getSingleton(){
        if(lazyOne == null){
            return new LazyOne();
        }
        return lazyOne;
    }
}
