package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: zhaoshiping
 * @Date: Created in 18:42 2019/11/12
 * @Description: 编码与解码操作工具类
 * @Version:
 */
public final class CodeCUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(CodeCUtil.class);

    /**
     * 将Url编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target;
        try {
            target= URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将url解码
     * @param s
     * @return
     */
    public static String decodeURL(String s){
        String target;
        try {
            target= URLDecoder.decode(s,"utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }

}
