package com.cx.designpatterns.singleton.lazy;

/**
 * 1、外部类被调用的时候,静态内部类会被初始化
 * 2、内部类一定会在调用 getSingleton 方法之前,被初始化
 * 3、避免的线程安全的问题
 *
 * 这种方式即避免了饿汉式的内存浪费,也避免了synchronize带来的性能问题
 *
 *
 * @author:wuming
 */
public class LazyTwo {

    public static boolean initialized = false;

    private LazyTwo(){
        synchronized (LazyTwo.class){
            if(initialized==false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("违反单例");
            }
        }
    }
    public static final LazyTwo getSingleton(){
        return LazyHolder.LAZY;
    }

    //默认情况不会被初始化
    private static class LazyHolder{
        private static final LazyTwo LAZY = new LazyTwo();
    }
}
