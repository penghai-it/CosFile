package it.ph.com.cosfiletest.service.designPattern.factory;

/**
 * @author PH
 * @时间： 2023/1/30
 * @描述： 抽象工厂（负责产品对象的生产）
 */
public abstract class Creator {
    /**
     * 创建一个产品对象 其输入的参数可以自行设置
     * 通常为String Enum Class等，可以为空
     **/

    public abstract <T extends Product> T concreteCreator(Class<T> c);
}
