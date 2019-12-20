package org.smart.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: zhaoshiping
 * @Date: Created in 15:49 2019/11/12
 * @Description: 流操作工具类
 * @Version:
 */
public final class StreamUtil {

    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
