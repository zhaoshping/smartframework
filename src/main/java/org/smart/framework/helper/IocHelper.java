package org.smart.framework.helper;


import org.smart.framework.annotation.Inject;
import org.smart.framework.util.ArrayUtil;
import org.smart.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author: zhaoshiping
 * @Date: Created in 14:16 2019/11/11
 * @Description: 依赖注入助手类
 * @Version:
 */
public final class IocHelper {

    static {
        //获取所有的Bean类和Bean实例之间的映射关系(简称Bean Map)
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        //此处可以写一个工具类来判断beanMap是不是空 我懒
        if (!beanMap.isEmpty()) {
            //遍历Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从beanmap中获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanIntance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历Bean field
                    for (Field beanField : beanFields) {
                        //判断当前bean field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在BeanMap中获取Bean field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setFiled(beanIntance, beanField, beanFieldInstance);
                            }

                        }
                    }

                }


            }

        }

    }
}
