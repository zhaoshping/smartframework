package org.smart.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.annotation.Aspect;
import org.smart.framework.annotation.Contrller;

import java.lang.reflect.Method;

/**
 * @author: zhaoshiping
 * @Date: Created in 17:55 2019/11/20
 * @Description: 拦截controller所有方法
 * @Version:
 */
@Aspect(Contrller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger logger= LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;
    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.info("---------------begin-------------");
        begin=System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        logger.info(String.format("time：%dms",System.currentTimeMillis()-begin));
       logger.info("-------------end");
    }
}
