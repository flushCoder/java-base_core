package com.cx.designpatterns.factory.factory;

import com.cx.designpatterns.factory.Mengniu;
import com.cx.designpatterns.factory.Milk;

/**
 * @author:wuming
 */
public class MengniuFactory implements Factory{
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
