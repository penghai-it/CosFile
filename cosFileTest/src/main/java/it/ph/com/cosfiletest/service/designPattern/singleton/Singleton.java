package it.ph.com.cosfiletest.service.designPattern.singleton;

import lombok.Data;

/**
 * @author PH
 * @时间： 2023/1/29
 * @描述：设计模式学习_单列模式之单例模式
 */
@Data
public class Singleton {
    private Long id;
    private String name;
    private int age;

    /**
     * 私有构造方法，防止被实例化
     **/

    private Singleton() {
    }

    /**
     * 使用一个内部内来维护单例
     **/
    private static class SingletonFactory {
        public static Singleton singleton = new Singleton();
    }

    /**
     * 获取实例
     **/

    public static Singleton getInstance() {
        return SingletonFactory.singleton;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     **/

    public Object readResolve() {
        return getInstance();
    }


    public static void main(String[] args) {
        //使用单列模式创建对象
        Singleton instance = Singleton.getInstance();
        instance.setId(1L);
        instance.setName("张三");
        instance.setAge(18);

        //使用单列模式创建对象
        Singleton instance1 = Singleton.getInstance();
        instance.setId(2L);
        instance.setName("李四");
        instance.setAge(20);
        System.out.println(instance);
        System.out.println(instance1);

        //使用new创建对象
        Singleton singleton = new Singleton();
        singleton.setId(3L);
        singleton.setName("王五");
        singleton.setAge(22);
        System.out.println(singleton);

    }
}
