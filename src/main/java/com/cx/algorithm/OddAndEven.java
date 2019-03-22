package com.cx.algorithm;

/**
 * 交替打印基数偶数
 * @author wuming
 * @create 2019/3/22 17:36
 */
public class OddAndEven {
    public boolean flag;
    public class OddClass implements Runnable {
        public OddAndEven t;
        public OddClass(OddAndEven t) {
            this.t = t;
        }

        @Override
        public void run() {
            int i = 1;  //本线程打印奇数,则从1开始
            while (i < 100) {
                synchronized (t) {
                    if (!t.flag) {
                        System.out.println("奇数：" + i);
                        i += 2;
                        t.flag = true;
                        t.notify();
                    } else {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }


    public class EvenClass implements Runnable {
        public OddAndEven t;
        public EvenClass(OddAndEven t) {
            this.t = t;
        }

        @Override
        public void run() {
            int i = 2;
            while (i <= 100)
                synchronized (t) {
                    if (t.flag) {
                        System.out.println("偶数：" + i);
                        i += 2;
                        t.flag = false;
                        t.notify();
                    } else {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }

    public static void main(String[] args) {
        OddAndEven tt = new OddAndEven();
        OddClass jiClass = tt.new OddClass(tt);
        EvenClass ouClass = tt.new EvenClass(tt);
        new Thread(jiClass).start();
        new Thread(ouClass).start();
    }
}
