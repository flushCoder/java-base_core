package com.cx.designpatterns.adapter;

/**
 * 适配器模式: 是对原来代码的包装,适配新的功能
 * @author wuming
 * @date 2019/3/3 13:49
 */
public class SiginForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法
        return loginForRegist(openId,null);

    }

    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);
    }

}
