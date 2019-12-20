package org.smart.framework.helper;

import org.smart.framework.annotation.Aspect;
import org.smart.framework.proxy.AspectProxy;
import org.smart.framework.proxy.Proxy;
import org.smart.framework.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhaoshiping
 * @Date: Created in 18:59 2019/11/20
 * @Description:
 * @Version:
 */
public class AopHelper {
    static {
        try {
            Map<Class<?>,Set<Class<?>>> proxyMap=createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            for(Map.Entry<Class<?>,List<Proxy>> targetEntry:targetMap.entrySet()){
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass,proxy);
            }
        }catch (Exception e){

        }
    }

    //找到一堆带有controller注解的类？
    private static Set<Class<?>> createTargetClassSet(Aspect aspect)throws Exception{
        Set<Class<?>> targetClassSet=new HashSet<Class<?>>();
        Class<? extends Annotation> annotaion=aspect.value();
        if(annotaion!=null && !annotaion.equals(Aspect.class)){
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotaion));
        }
        return targetClassSet;
    }

    private static Map<Class<?>,Set<Class<?>>> createProxyMap()throws Exception{
        Map<Class<?>,Set<Class<?>>> proxyMap=new HashMap<Class<?>, Set<Class<?>>>();
        //获得所有子类
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for(Class<?> proxyClass:proxyClassSet){
            Aspect aspect = proxyClass.getAnnotation(Aspect.class);
            Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
            proxyMap.put(proxyClass,targetClassSet);

        }
        return proxyMap;
    }

    private static Map<Class<?>, List<Proxy>> createTargetMap( Map<Class<?>,Set<Class<?>>> proxyMap)throws Exception{
        Map<Class<?>, List<Proxy>> targetMap=new HashMap<Class<?>, List<Proxy>>();
        for (Map.Entry<Class<?>,Set<Class<?>>> proxyEntry:proxyMap.entrySet()){
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();

            for(Class<?> targetClass:targetClassSet){
                Proxy proxy=(Proxy)proxyClass.newInstance();
                if(targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else {
                    List<Proxy> proxyList=new ArrayList<Proxy>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass,proxyList);
                }

            }



        }
        return targetMap;
    }
}
