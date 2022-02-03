package com.imooc.ad.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class CommonUtils {

    /**
     * 加密方法
     * @param value
     * @return
     */
    public static String MD5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }
}
