package com.cx.utils.redis;

/**
 * Created by taokai on 2018/2/23.
 */
public class TimeUtil {

    public static long current() {
        return System.currentTimeMillis();
    }

    public static long diffMills(long start) {
        return current() - start;
    }

    public static double diffSec(long start) {
        return (current() - start) / 1000.0;
    }

}
