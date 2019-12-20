package org.smart.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.Oneway;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhaoshiping
 * @Date: Created in 10:32 2019/11/11
 * @Description: 反射工具类
 * @Version:
 */
public class ReflectionUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls){
        Object instance;

        try {
            instance=cls.newInstance();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param oj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object oj, Method method,Object...args){
        Object result;
        try {
            method.setAccessible(true);
            result=method.invoke(oj,args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setFiled(Object obj, Field field,Object value){

        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
