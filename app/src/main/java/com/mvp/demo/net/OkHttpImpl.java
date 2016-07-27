package com.mvp.demo.net;

import com.zhy.http.okhttp.OkHttpUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 创建人：
 * 创建时间： 2016/7/26 14
 * 功能概述: 根据业务封装
 * 修改人：
 * 修改时间：
 */
public class OkHttpImpl {

    private static final String TAG = OkHttpImpl.class.getSimpleName();

    private static OkHttpUtils mHttpUtils;

    //签名
    public static String makeSign(String uid, String method){
        return md5(uid + "|" + NetContant.SERVER_KEY + "|" + method);
    }

    private static String md5(String inStr){
        //LogUtil.d("md5 str = " + inStr);
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
