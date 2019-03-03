package com.cx.designpatterns.adapter;

/**
 * @author wuming
 * @date 2019/3/3 13:45
 */
public class SiginService {

    public ResultMsg login(String username, String password){
        return new ResultMsg("sucess", "登陆成功", new User());
    }

    public ResultMsg regist(String username, String password){
        return new ResultMsg("sucess", "注册成功", new User());
    }
}
