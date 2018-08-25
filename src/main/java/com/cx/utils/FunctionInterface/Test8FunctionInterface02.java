package com.cx.utils.FunctionInterface;

import java.util.Iterator;
import java.util.function.Function;


public class Test8FunctionInterface02 {

    public static void main(String[] args){
        Test8FunctionInterface02 test8FunctionInterface02 = new Test8FunctionInterface02();
        test8FunctionInterface02.method3(()->System.out.println("hello"));
        test8FunctionInterface02.method2("hello", test8FunctionInterface02::method1);
        test8FunctionInterface02.method3(test8FunctionInterface02::method4);
    }

    public String method1(String str){
        System.out.println(str);
        return "6666";
    }

    public <Q, K> K method2(Q q, Function<Q, K> fun){
        K k = fun.apply(q);
        return k;
    }

    public void method3(A a){

    }

    public void method4(){
        System.out.println("123");
    }
}

interface X{
    int m(Iterator<String> arg);
}

interface Y{
    int m(Iterator<String> arg);
}

@FunctionalInterface
interface Z extends X,Y{

}
