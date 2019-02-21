package com.cx.designpatterns.factory.factory;

import com.cx.designpatterns.factory.Milk;
import com.cx.designpatterns.factory.Yili;

/**
 * @author:wuming
 */
public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
