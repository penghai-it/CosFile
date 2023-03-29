package it.ph.com.cosfiletest.service.designPattern.factory;

import it.ph.com.cosfiletest.mode.UserTest;

/**
 * @author PH
 * @时间： 2023/1/30
 * @描述： 具体的工厂类（具体如何如何生产一个产品对象，是由具体的工厂类实现）
 */
public class ConcreteCreator extends Creator {
    @Override
    public <T extends FactoryProduct> T concreteCreator(Class<T> c) {
        FactoryProduct product = null;
        try {
            product = (FactoryProduct) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            //异常处理
        }
        return (T) product;
    }

    /**
     * 工厂模式加单例模式结合使用
     **/
    public static void main(String[] args) {
        ConcreteCreator concreteCreator = new ConcreteCreator();
        ConcreteCreator1 concreteCreator1 = concreteCreator.concreteCreator(ConcreteCreator1.class);
        //业务处理

        UserTest instance = UserTest.getInstance();
        instance.setId(1);
        instance.setName("张三");
        instance.setAge(18);
        concreteCreator1.model2(instance);

        ConcreteCreator2 concreteCreator2 = concreteCreator.concreteCreator(ConcreteCreator2.class);
        instance.setId(2);
        instance.setName("李四");
        instance.setAge(20);
        concreteCreator2.model2(instance);
    }
}
