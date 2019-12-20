package org.smart.framework;

import org.smart.framework.helper.AopHelper;
import org.smart.framework.helper.BeanHelper;
import org.smart.framework.helper.ClassHelper;
import org.smart.framework.helper.ControllerHelper;
import org.smart.framework.helper.IocHelper;
import org.smart.framework.util.ClassUtil;

/**
 * @author: zhaoshiping
 * @Date: Created in 9:47 2019/11/12
 * @Description: 加载相应的helper类  这是一个框架入口 来初始化框架
 * @Version:
 */
public final class HelperLoader {

    /**
     * 在第一次访问类的时候就会加载其static类 这里只是为了让加载更加集中，所以才写了一个HelperLoader类
     */
    public static void init(){
        Class<?>[] classList ={
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
