package org.smart.framework.bean;

import java.util.Map;

/**
 * @author: zhaoshiping
 * @Date: Created in 10:07 2019/11/12
 * @Description: 请求参数对象
 * @Version:
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return Long.valueOf((String) paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
