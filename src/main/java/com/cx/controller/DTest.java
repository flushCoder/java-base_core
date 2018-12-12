package com.cx.controller;

import com.alibaba.fastjson.JSON;
import com.cx.bean.RepaymentDetailDTO;
import com.cx.bean.RepaymentDetailData;
import com.cx.service.OpenRecordService;
import com.cx.service.RepaymentPlanService;
import com.cx.utils.RASStatic.RSAEncrypt;
import com.cx.utils.RASStatic.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.math.BigDecimal;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/v1")
public class DTest {

    @Autowired
    private OpenRecordService openRecordService;

    @Autowired
    private RepaymentPlanService repaymentPlanService;

    @GetMapping("/demo1")
    @ResponseBody
    public String demo1() throws Exception {

        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\tn-13\\Desktop\\test.txt");
        String pathname = "C:\\Users\\tn-13\\Desktop\\test.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename), "utf-8"); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        while ( (line = br.readLine()) != null) {
            System.out.println(line);
            String[] split = line.split("\\|");
            System.out.println(split.length);
            /*if(split.length != 8){
                return "";
            }*/
            RepaymentDetailData repaymentDetailData = new RepaymentDetailData();
            repaymentDetailData.setBankCard(split[0]);
            repaymentDetailData.setBankName(split[1]);
            repaymentDetailData.setRepaymentDate(split[3]);
            repaymentDetailData.setRepaymentAmount(new BigDecimal(split[4]));
            repaymentDetailData.setSceneId(Integer.parseInt(split[5]));
            repaymentDetailData.setBatchNo(split[6]);
            String[] repaymentDetailArr = split[7].split("^");
            List<RepaymentDetailDTO> repaymentDetailDTOList = new ArrayList<>();
            for(String ss : repaymentDetailArr){
                String[] repaymentDetail = ss.split(",");
                RepaymentDetailDTO repaymentDetailDTO = new RepaymentDetailDTO();
                repaymentDetailDTO.setSceneId(Integer.parseInt(repaymentDetail[0]));
                repaymentDetailDTO.setOutOrderNo(repaymentDetail[1]);
                repaymentDetailDTO.setTerm(Integer.parseInt(repaymentDetail[2]));
                repaymentDetailDTO.setDebitDate(repaymentDetail[3]);
                repaymentDetailDTO.setRepaymentAmount(new BigDecimal(repaymentDetail[5]));
                repaymentDetailDTO.setActualCapital(new BigDecimal(repaymentDetail[6]));
                repaymentDetailDTO.setActualInterest(new BigDecimal(repaymentDetail[7]));
                repaymentDetailDTO.setServiceCharge(new BigDecimal(repaymentDetail[8]));
                repaymentDetailDTOList.add(repaymentDetailDTO);
            }
            repaymentDetailData.setRepaymentDetailDTOList(repaymentDetailDTOList);
            System.out.println(JSON.toJSONString(repaymentDetailData));
            String str = JSON.toJSONString(repaymentDetailData);

        }
        return "";
    }

    @GetMapping("/demo2")
    @ResponseBody
    public String demo2() throws Exception {
        String str = "{\"address\":\"绿地北外滩中心6633号\",\"bankCard\":\"6217901458664717335\",\"bankName\":\"中国银行\",\"city\":\"市辖区\",\"contact\":[{\"mobile\":\"13026805318\",\"name\":\"杨坤\",\"relation\":\"11001\",\"sceneId\":\"10040002\"}],\"custName\":\"刘吉祥\",\"education\":\"2004\",\"email\":\"123456@qq.com\",\"empAddress\":\"绿地北外滩中心7224号\",\"empName\":\"上海前隆\",\"empTelephone\":\"021-3339-3690\",\"idCard\":\"421182199210142518\",\"idCardType\":\"01\",\"mobile\":\"18627812900\",\"payCode\":\"BOC\",\"phoneByBank\":\"15060413067\",\"province\":\"上海市\",\"registryAddress\":\"上海市黄浦区浙江南路209号\",\"sceneId\":\"10040002\",\"userAcct\":\"17951863\"}";
        byte[] encrypt = RSAEncrypt.encrypt(RSAEncrypt.publicKey, str.getBytes("utf-8"));
        String encryptStr = RSAEncrypt.base64encode(encrypt);
        System.out.println("加密后的密文："+encryptStr);
        //生签
        String sign = RSAUtil.sign(str.getBytes(), RSAEncrypt.privateKeyString);
        System.out.println("签名是："+sign);

        RSAPrivateKey privateKey = null;
        String publicKey = "";
        publicKey = getPublicKeyString();

        //解密
        byte[] plainText = RSAEncrypt.decrypt(null, RSAEncrypt.base64decode(encryptStr));
        String ss = new String(plainText,"utf-8");
        System.out.println("解密后的数据："+ss);

        //验签
        boolean verify = RSAUtil.verify(str.getBytes(), publicKey, sign);
        System.out.println(verify);

        return "";
    }

    public static String getPublicKeyString() throws Exception {
        String publicKey = "";
        publicKey = RSAEncrypt.publicKeyString;
        if(!StringUtils.isEmpty(publicKey)){
            return publicKey;
        }
        InputStream isPublic = RSAEncrypt.class.getClassLoader().getResourceAsStream("taicredit_public_key.pem");
        publicKey = RSAUtil.loadPemKey(isPublic);
        if(!StringUtils.isEmpty(publicKey)){
            return publicKey;
        }
        //异常通知
        return null;
    }
}
