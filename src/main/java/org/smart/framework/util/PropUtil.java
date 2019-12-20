package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author: zhaoshiping
 * @Date: Created in 14:07 2019/11/7
 * @Description: 属性文件工具类
 * @Version:
 */
public final class PropUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropUtil.class);

    /**
     * 加载配置文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }
    public static String getString(Properties properties,String key){
        return getString(properties,key,"");
    }
    public static String getString(Properties properties,String key,String defaultValue){
        String value=defaultValue;
        if(properties.containsKey(key)){
            value=properties.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties properties,String key){
        return getInt(properties,key,0);
    }
    public static int getInt(Properties properties,String key,int defaultValue){
        int value=defaultValue;
        if(properties.containsKey(key)){
            value=Integer.valueOf(properties.getProperty(key));
        }
        return value;
    }

    public static boolean getBoolean(Properties properties,String key){
        return getBoolean(properties,key,false);
    }
    public static boolean getBoolean(Properties properties,String key,boolean defaultValue){
        boolean value=defaultValue;
        if(properties.containsKey(key)){
            value=properties.getProperty(key)==null?false:true;
        }
        return value;
    }
}
