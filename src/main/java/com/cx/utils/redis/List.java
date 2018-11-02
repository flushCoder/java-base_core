package com.cx.utils.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

public class List {

    public static void main(String[] args) {
        /*// 通过StringRedisTemplate获得ZSetOperations，操作ZSet有序集合
        ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();
        // a1到a10，分别是1分到10分
        zSetOperations.add("wy:test3:", "a1", 1);
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
        System.out.println("a1 revrank:" + zSetOperations.reverseRank("wy:test3:", "a1")); // 9
        System.out.println("a2 revrank:" + zSetOperations.reverseRank("wy:test3:", "a2")); // 8
        // a1加2分，再加1.5分
        zSetOperations.incrementScore("wy:test3:", "a1", 2);
        zSetOperations.incrementScore("wy:test3:", "a1", 1.5);
        // a1是4.5分，排名第7名；而a2变成了第10名
        System.out.println("a1 score:" + zSetOperations.score("wy:test3:", "a1")); // 4.5
        System.out.println("a1 revrank:" + zSetOperations.reverseRank("wy:test3:", "a1")); // 6
        System.out.println("a2 revrank:" + zSetOperations.reverseRank("wy:test3:", "a2")); // 9
        // 删除测试数据 wy:test3:
        zSetOperations.remove("wy:test3:");*/
    }
}
