package com.cx.designpatterns.proxy.staticed;

/**
 * 代理
 * 静态代理:在代理之前,所有东西都是已知的(编译时期就知道具体引用) 人工
 * 动态代理:在代理之前,所有东西都是未知的(运行时才知道具体的引用) 自动化
 * @author:wuming
 */
public interface Person {

    void findLove();
}
