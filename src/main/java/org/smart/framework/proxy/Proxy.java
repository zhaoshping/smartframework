package org.smart.framework.proxy;

/**
 * @author: zhaoshiping
 * @Date: Created in 19:16 2019/11/19
 * @Description:
 * @Version: 代理接口
 */
public interface Proxy {
    /**
     * 执行链式代理
     * @param proxychain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxychain) throws Throwable;
}