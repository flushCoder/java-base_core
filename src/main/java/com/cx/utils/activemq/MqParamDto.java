package com.cx.utils.activemq;


import java.io.Serializable;

public class MqParamDto implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
