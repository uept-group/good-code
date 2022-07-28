package tech.uept.java.good.code.codec;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

    // 编码
    public static String encode(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            byte[] bs = str.getBytes("UTF-8");
            return Base64.getEncoder().encodeToString(bs);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 解码
    public static String decode(String base64) {
        if (base64 == null || base64.isEmpty()) {
            return "";
        }
        byte[] bs1 = Base64.getDecoder().decode(base64);
        try {
            return new String(bs1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}