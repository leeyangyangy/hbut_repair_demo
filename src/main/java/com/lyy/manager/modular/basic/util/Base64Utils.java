package com.lyy.manager.modular.basic.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Utils {
    /**
     *  base64原理
     *  base64编码：把二进制数据转为字符
     *  base64解码：把字符转为二进制数据
     */

    /**
     * 编码
     * @param content
     * @return
     */
    public static String encode(byte[] content) {
        return new BASE64Encoder().encode(content);
    }

    /**
     * 解码
     * @param source
     * @return
     */
    public static byte[] decode(String source) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return decoder.decodeBuffer(source);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("解码异常");
        }
        return null;
    }
}
