package com.cx.designpatterns.singleton.hungry;

import javax.management.monitor.CounterMonitor;
import java.util.concurrent.CountDownLatch;

/**
 * @author:wuming
 */
public class HungrySingletonTest {
    public static void main(String[] args) {

        int count = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        for(int i = 1;i<=count;i++){
            new Thread(){
                @Override
                public void run() {
                    HungrySingleton.getSingleton();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            countDownLatch.countDown();
        }
    }
}
