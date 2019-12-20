package org.smart.framework.helper;

import org.smart.framework.annotation.Contrller;
import org.smart.framework.annotation.Service;
import org.smart.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhaoshiping
 * @Date: Created in 10:09 2019/11/11
 * @Description:
 * @Version:
 */
public class ClassHelper {

    /**
     * 定义类集合 用于存放所有加载的类
     */
    private static  final Set<Class<?>> CLASS_SET;

    static {
        String basePackage=ConfigHelper.getAppBasePakage();
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有的service类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有的Controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Contrller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有bean类(包括service controller等)
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

    /**
     * 获得应用包名下某父类（或接口）的所有子类(或实现类）
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class cls:CLASS_SET){
            if(superClass.isAssignableFrom(cls)&&!superClass.equals(cls)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    public static Set<Class<?>> getClassSetByAnnotation( Class<? extends Annotation> annotation){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class cls:CLASS_SET){
            if(cls.isAnnotationPresent(annotation)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
