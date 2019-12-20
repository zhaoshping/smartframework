package org.smart.framework.helper;

import org.smart.framework.annotation.Action;
import org.smart.framework.bean.Handler;
import org.smart.framework.bean.Request;
import org.smart.framework.util.ArrayUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhaoshiping
 * @Date: Created in 18:51 2019/11/11
 * @Description: 控制器助手类
 * @Version:
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP=new HashMap<Request, Handler>();

    static {
        //获取所有controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(!controllerClassSet.isEmpty()){
            //遍历这些controller类
            for(Class<?> cls:controllerClassSet){
                //获取controller类中定义的方法
                Method[] controllerMethods = cls.getDeclaredMethods();
                //遍历这些controller方法
                for(Method method:controllerMethods){
                    //判断这些方法上是否有action注解
                    if(method.isAnnotationPresent(Action.class)){
                        //从注解中获取URL映射规则
                        Action action = method.getAnnotation(Action.class);
                        String mapping=action.value();
                        //验证URl映射规则
                        if(mapping.matches("\\w+:/\\w")){
                            String [] array=mapping.split(":");
                            if(ArrayUtil.isNotEmpty(array)&&array.length==2){
                                //获取请求方法与请求路径
                                String requestMethod=array[0];
                                String requestPath=array[1];
                                Request request=new Request(requestMethod,requestPath);
                                Handler handler=new Handler(cls,method);
                                ACTION_MAP.put(request,handler);
                            }
                        }
                    }
                }

            }

        }
    }

    public static Handler getHandler(String requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
       return ACTION_MAP.get(request);
    }
}
