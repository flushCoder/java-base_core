package com.cx.utils.RASStatic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("/demo2")
    @ResponseBody
    public String demo2() throws Exception {
        String str = "123432c";
        byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.publicKey, str.getBytes());
        String encryptStr = RSAEncrypt.base64encode(encrypt);
        System.out.println("加密后的密文："+encryptStr);
        //生签
        String sign = RSAUtil.sign(str.getBytes(), RSAEncrypt.privateKeyString);
        System.out.println("签名是："+sign);

        //解密
        byte[] plainText = RSAEncrypt.decrypt(RSAEncrypt.privateKey, RSAEncrypt.base64decode(encryptStr));
        String ss = new String(plainText,"utf-8");
        System.out.println("解密后的数据："+ss);

        //验签
        boolean verify = RSAUtil.verify(str.getBytes(), RSAEncrypt.publicKeyString, sign);
        System.out.println(verify);

        return "";
    }
}
