package org.smart.framework.proxy;

/**
 * @author: zhaoshiping
 * @Date: Created in 14:13 2019/12/17
 * @Description:
 * @Version:
 */
public class TransactionProxcy implements Proxy{

    private static final ThreadLocal<Boolean> FLAG_HOLDER=new ThreadLocal<Boolean>(){
        /**
         * Returns the current thread's "initial value" for this
         * thread-local variable.  This method will be invoked the first
         * time a thread accesses the variable with the {@link #get}
         * method, unless the thread previously invoked the {@link #set}
         * method, in which case the <tt>initialValue</tt> method will not
         * be invoked for the thread.  Normally, this method is invoked at
         * most once per thread, but it may be invoked again in case of
         * subsequent invocations of {@link #remove} followed by {@link #get}.
         *
         * <p>This implementation simply returns <tt>null</tt>; if the
         * programmer desires thread-local variables to have an initial
         * value other than <tt>null</tt>, <tt>ThreadLocal</tt> must be
         * subclassed, and this method overridden.  Typically, an
         * anonymous inner class will be used.
         *
         * @return the initial value for this thread-local
         */
        @Override
        protected Boolean initialValue() {
            return false;
        }
    };
    /**
     * 执行链式代理
     *
     * @param proxychain
     * @return
     * @throws Throwable
     */
    public Object doProxy(ProxyChain proxychain) throws Throwable {
        return null;
    }
}
