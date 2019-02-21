package com.cx.designpatterns.factory.abstractfactory;

import com.cx.designpatterns.factory.Mengniu;
import com.cx.designpatterns.factory.Milk;
import com.cx.designpatterns.factory.Telunsu;
import com.cx.designpatterns.factory.Yili;

/**
 * @author:wuming
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }
}
