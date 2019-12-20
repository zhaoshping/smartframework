package org.smart.framework.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaoshiping
 * @Date: Created in 19:20 2019/11/19
 * @Description:
 * @Version: 代理链
 */
public class ProxyChain {
    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodPatams;

    private List<Proxy> proxyList=new ArrayList<Proxy>();

    private int proxyIndex=0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] methodPatams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodPatams = methodPatams;
        this.proxyList = proxyList;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getMethodPatams() {
        return methodPatams;
    }

    public Object doProxyChain() throws Throwable{
        Object methodResult;
        if (proxyIndex<proxyList.size()){
            methodResult=proxyList.get(proxyIndex++).doProxy(this);
        }else {
            methodResult=methodProxy.invokeSuper(targetObject,methodPatams);
        }
        return methodResult;
    }
}
