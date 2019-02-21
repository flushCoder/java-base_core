package com.cx.designpatterns.factory.factory;

import com.cx.designpatterns.factory.Milk;

/**
 * 工厂模式: 每个工厂生产专门的产品
 * @author:wuming
 */
public interface Factory {

    Milk getMilk();
}
