package it.ph.com.cosfiletest.utils;

import org.springframework.stereotype.Component;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述: 拦截器类
 */
@Component
public class ThreadLocalUtils {
    private static ThreadLocal<String> tokenThreadLocal = new ThreadLocal<>();

    public static void setTableName(String tableName) {
        tokenThreadLocal.set(tableName);
    }

    public static String getTableName() {
        return tokenThreadLocal.get();
    }

    public static void removeTableName() {
        if (tokenThreadLocal.get() != null) {
            tokenThreadLocal.remove();
        }
    }
}
