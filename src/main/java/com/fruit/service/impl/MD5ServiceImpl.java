package com.fruit.service.impl;

import com.fruit.service.MD5Service;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5ServiceImpl implements MD5Service {

    @Override
    public String Get_MD5(String str) {
        String result=null;
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            result= new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
