package com.cx.designpatterns.singleton.register;

import com.cx.designpatterns.singleton.hungry.HungrySingleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author:wuming
 */
public class Test {
    public static void main(String[] args) {
        int count = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        for(int i = 1;i<=count;i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RegisterMap singleton = RegisterMap.getSingleton("com.cx.designpatterns.singleton.register.TestClass");
                    System.out.println(System.currentTimeMillis() +":" + singleton);
                }
            }.start();
            countDownLatch.countDown();
        }
    }
}
