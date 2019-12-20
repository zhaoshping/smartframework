package org.smart.framework.bean;

import java.lang.reflect.Method;

/**
 * @author: zhaoshiping
 * @Date: Created in 18:47 2019/11/11
 * @Description:
 * @Version:
 */
public class Handler {

    /**
     * Controller类
     */
    private Class<?> controllerClass;
    /**
     * 请求方法
     */
    private Method  actionMethod;

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }
}
