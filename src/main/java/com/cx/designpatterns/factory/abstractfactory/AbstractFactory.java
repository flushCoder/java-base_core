package com.cx.designpatterns.factory.abstractfactory;

import com.cx.designpatterns.factory.Milk;

/**
 * @author:wuming
 */
public abstract class AbstractFactory {

    public abstract Milk getMengniu();

    public abstract Milk getTelunsu();

    public abstract Milk getYili();

}
