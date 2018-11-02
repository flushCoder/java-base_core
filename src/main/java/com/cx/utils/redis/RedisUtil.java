package com.cx.utils.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.concurrent.TimeUnit;


public class RedisUtil {

    public static final Logger log = LoggerFactory.getLogger(RedisUtil.class);
    private static StringRedisTemplate stringRedisTemplate;

    /**
     * 放入redis中 k,v均为String
     *
     * @param key
     * @param val
     * @param seconds
     */
    public static void set(String key, Object val, long seconds) {
        try {
            stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(val), seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("redis 写入异常 key:" + key, e);
        }
    }

    /**
     * 放入redis中 k,v均为String
     *
     * @param key
     * @param val
     */
    public static void set(String key, String val) {
        try {
            stringRedisTemplate.opsForValue().set(key, val);
        } catch (Exception e) {
            log.error("redis 写入异常 key:" + key, e);
        }
    }

    /**
     * 放入redis中 k,v均为String
     * 过期时间:秒
     */
    public static void setExpire(String key, String val, long seconds) {
        try {
            stringRedisTemplate.opsForValue().set(key, val, seconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("redis 写入异常 key:" + key, e);
        }
    }


    /**
     * 从redis取值 异常返回null
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String res = null;
        try {
            res = stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("redis 读取异常key" + key, e);
        }
        return res;
    }

    /**
     * 删除
     */
    public static void delete(String key) {
        try {
            stringRedisTemplate.delete(key);
        } catch (Exception e) {
            log.error("redis 删除异常key:" + key, e);
        }
    }

    /**
     * 如果缺失即设置
     *
     * @param key
     * @param value
     * @return 设置是否成功
     */
    public static boolean setNX(String key, String value) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 为key设置新值
     *
     * @param key
     * @param newValue
     * @return 返回旧值
     */
    public static String getSet(String key, String newValue) {
        return stringRedisTemplate.opsForValue().getAndSet(key, newValue);
    }


    /**
     * 加锁
     *
     * @param lockKey 需要锁定的key
     * @param expire  过期时间（单位:秒） 配置的过期时间应小于任务间隔时间
     * @return 是否取得锁
     */
    public static boolean lock(String lockKey, long expire) {
        log.info("TnRedisUtil--lock开始 lockKey:{},expire:{}", lockKey, expire);
        try {
            //锁过期时间 换算成毫秒
            long expires = TimeUtil.current() + expire * 1000 + 1;
            String expireStr = String.valueOf(expires);
            if (setNX(lockKey, expireStr)) {//设置成功
                return true;
            } else {//如果设置失败 判断是否过期
                //获取当前redis中lockKey的过期时间
                String currValueStr = get(lockKey);
                //判断已有锁是否过期
                if (StringUtils.isNotBlank(currValueStr) && Long.parseLong(currValueStr) < TimeUtil.current()) {
                    //获取上一个锁的过期时间并设置当前锁的到期时间 可能有多个进程到达此处
                    String oldValueStr = getSet(lockKey, expireStr);
                    //只有一个线程能获取到上一个锁的过期时间
                    if (StringUtils.isNotBlank(oldValueStr) && oldValueStr.equals(currValueStr)) {
                        //只有一个进程能获取到匹配的旧值从而获取到锁
                        return true;
                    }
                }
                return false;
            }
        } catch (Exception e) {
            log.error("lock失败 key:" + lockKey, e);
            return false;
        }
    }

    /**
     * 解锁
     */
    public static void unlock(String key) {
        delete(key);
    }


    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public static void rank() {
        // 通过StringRedisTemplate获得ZSetOperations，操作ZSet有序集合
        ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();
        // a1到a10，分别是1分到10分
        System.out.println(zSetOperations.add("wy:test3:", "a1", 1));
        zSetOperations.add("wy:test3:", "a2", 2);
        zSetOperations.add("wy:test3:", "a3", 3);
        zSetOperations.add("wy:test3:", "a4", 4);
        zSetOperations.add("wy:test3:", "a5", 5);
        zSetOperations.add("wy:test3:", "a6", 6);
        zSetOperations.add("wy:test3:", "a7", 7);
        zSetOperations.add("wy:test3:", "a8", 8);
        zSetOperations.add("wy:test3:", "a9", 9);
        zSetOperations.add("wy:test3:", "a10", 10);
        // a1是1分，排名第10名；a2是2分，排名第9
        System.out.println("a1 score:" + zSetOperations.score("wy:test3:", "a1")); // 1.0
        System.out.println("a1 revrank:" + zSetOperations.reverseRank("wy:test3:", "a10")); // 9
        System.out.println("a2 revrank:" + zSetOperations.reverseRank("wy:test3:", "a2")); // 8
        // a1加2分，再加1.5分
        zSetOperations.incrementScore("wy:test3:", "a1", 2);
        zSetOperations.incrementScore("wy:test3:", "a1", 1.5);
        // a1是4.5分，排名第7名；而a2变成了第10名
        System.out.println("a1 score:" + zSetOperations.score("wy:test3:", "a1")); // 4.5
        System.out.println("a1 revrank:" + zSetOperations.reverseRank("wy:test3:", "a1")); // 6
        System.out.println("a2 revrank:" + zSetOperations.reverseRank("wy:test3:", "a2")); // 9
        // 删除测试数据 wy:test3:
        //zSetOperations.remove("wy:test3:");
    }

}
