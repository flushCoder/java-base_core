package com.cx.utils.stream;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "scala", "python", "shell", "ruby", "");
        long num = list.parallelStream().filter(x -> x.length() < 5).count();
        List<String> collect = list.stream().filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.toList());
        long count = list.stream().filter(x -> !StringUtils.isEmpty(x)).count();
        System.out.println(num);
        System.out.println(JSON.toJSON(collect));
        System.out.println(count);
        list.forEach(System.out::println);

        list.forEach(e->e="1");
        list.forEach(System.out::println);
        List<String> collect1 = list.stream().map(x -> x + "asdf").collect(Collectors.toList());
        collect1.stream().forEach(System.out::println);
    }

}
