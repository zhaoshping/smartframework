package org.smart.framework.helper;

import org.smart.framework.ConfigConstant;
import org.smart.framework.util.PropUtil;

import java.util.Properties;

/**
 * @author: zhaoshiping
 * @Date: Created in 14:02 2019/11/7
 * @Description: 属性文件助手类
 * @Version:
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePakage() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view");
    }

    public static String getAppJAssetPath() {
        return PropUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }


}
