package com.cx.utils.FunctionInterface;


@FunctionalInterface
public interface A extends B{

    void testA();

    default void testB1(){
    }

    default void testB2(){
    }
}
