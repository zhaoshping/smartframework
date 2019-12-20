package org.smart.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author: zhaoshiping
 * @Date: Created in 16:08 2019/11/11
 * @Description: 数组工具类
 * @Version:
 */
public class ArrayUtil {

    /**
     * 判断数据是否为空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数据是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }

}
