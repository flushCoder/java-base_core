package com.cx.utils.httpRequest;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * jdk 网络请求
 * HttpURLConnection
 */
public class JavaJDKPostRequest {

    public static void main(String[] args) throws Exception {

        int len = 1000;
        long sTime = System.currentTimeMillis();


        for(int i = 1;i<len;i++){
            String path = "http://localhost:9090/api/qianlong/receiveLoanResult";
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            conn.setReadTimeout(1000); //设置从主机读取数据超时（单位：毫秒）
            conn.setConnectTimeout(1000); //设置连接主机超时（单位：毫秒）
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false); //是否使用缓存
            conn.setUseCaches(false); //是否使用缓存
            //System.setProperty("sun.net.client.defaultConnectTimeout", "1000");   //设置连接主机超时（单位：毫秒）
            //System.setProperty("sun.net.client.defaultReadTimeout", "1000"); //设置从主机读取数据超时（单位：毫秒）
            conn.connect();
            // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法
            OutputStream os = conn.getOutputStream();
            Map<String, String> map = new HashMap<>();
            map.put("sign","qwe");
            map.put("data","qwe");
            os.write(JSON.toJSONString(map).getBytes());  //参数

            os.flush();
            os.close();
            int resultCode=conn.getResponseCode();
            if(resultCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = conn.getInputStream(); // <===注意，实际发送请求的代码段就在这里
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String str = br.readLine();
                System.out.println("相应内容====="+str+i);
            }else{
                InputStream inputStream = conn.getErrorStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String str = br.readLine();
                System.out.println("相应内容====="+str);
            }
            conn.disconnect();
        }
        long eTime = System.currentTimeMillis();
        long time = eTime - sTime;
        System.out.println(time);
    }
}
