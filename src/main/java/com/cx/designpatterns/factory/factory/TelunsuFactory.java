package com.cx.designpatterns.factory.factory;

import com.cx.designpatterns.factory.Milk;
import com.cx.designpatterns.factory.Telunsu;

/**
 * @author:wuming
 */
public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
