package org.smart.framework.proxy;

import java.lang.reflect.Method;

/**
 * @author: zhaoshiping
 * @Date: Created in 14:14 2019/11/20
 * @Description: 切面代理
 * @Version:
 */
public abstract class AspectProxy implements Proxy {
    /**
     * 执行链式代理
     *
     * @param proxychain
     * @return
     * @throws Throwable
     */
    public Object doProxy(ProxyChain proxychain) throws Throwable {
        Object result=null;

        Class<?> targetClass = proxychain.getTargetClass();
        Method targetMethod = proxychain.getTargetMethod();
        Object[] methodPatams = proxychain.getMethodPatams();
        begin();
        try{
            if(intercept(targetClass,targetMethod,methodPatams)){
                before(targetClass,targetMethod,methodPatams);
                result=proxychain.doProxyChain();
                after(targetClass,targetMethod,methodPatams);

            }else{
                result=proxychain.doProxyChain();

            }

        }catch (Exception e){
            error(targetClass,targetMethod,methodPatams);
            throw e;
        }finally {
            end();
        }
        return result;
    }
    public void begin(){}
    public boolean intercept(Class<?> cls,Method method,Object[] params)throws Throwable{
        return true;
    }
    public void before(Class<?> cls,Method method,Object[] params)throws Throwable{}

    public void after(Class<?> cls,Method method,Object[] params)throws Throwable{}
    public void error(Class<?> cls,Method method,Object[] params)throws Throwable{}
    public void end(){}
}
