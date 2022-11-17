package it.ph.com.cosfiletest.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/17
 * @描述：；类型转换工具类
 */
public class TypeConversionUtils {
    public static Map<String, String> objectTurnMap(Object object) {
        Map<String, String> map = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String value = null;
            try {
                Object obj = field.get(object);
                if (obj != null) {
                    value = String.valueOf(obj);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            map.put(fieldName, value);
        }
        return map;
    }
}
