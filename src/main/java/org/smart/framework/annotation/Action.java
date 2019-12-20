package org.smart.framework.annotation;

/**
 * @author: zhaoshiping
 * @Date: Created in 18:39 2019/11/8
 * @Description:
 * @Version:
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    /**
     * 请求类型与路径
     * @return
     */
    String value();
}
