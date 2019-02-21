package com.cx.designpatterns.factory.simplefactory;

import com.cx.designpatterns.factory.Mengniu;
import com.cx.designpatterns.factory.Milk;
import com.cx.designpatterns.factory.Telunsu;
import com.cx.designpatterns.factory.Yili;

/**
 * 简单工厂模式
 * 缺点:1 、所有的创建工作需要在一个类中完成,耦合度较高
 *      2 、系统增加或者修改产品时需要修改工厂类
 * @author:wuming
 */
public class SimpleFactory {

    public Milk getMilk(String name){
        if("特仑苏".equals(name)){
            return new Telunsu();
        }else if("蒙牛".equals(name)){
            return new Mengniu();
        }else if("伊利".equals(name)){
            return new Yili();
        }else{
            return null;
        }
    }
}
