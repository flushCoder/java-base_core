package com.cx.utils.ThreadDemo;


import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        RunTest runTest = new RunTest();
        Thread thread = new Thread(runTest);
        thread.start();
        //TimeUnit.SECONDS.sleep(3);
        thread.interrupt();
    }
}

class RunTest implements Runnable{

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                // System.out.println("sleep 5s");
                //Thread.sleep(5000);接收到中断信号时,由于while循环判断不成立退出,不抛出异常
                System.out.println("***************");
            }
            System.out.println("Exit normal");
        }catch(Exception e){
            System.out.println("interrupted");
        }
    }
}
