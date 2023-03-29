package it.ph.com.cosfiletest.service.templateMode;

/**
 * @author: P H
 * @时间: 2023/1/31
 * @描述: 场景类
 */
public class Client {
    public static void main(String[] args) {
        ConcreteClass1 concreteClass1 = new ConcreteClass1();
        concreteClass1.doAnything();
        concreteClass1.doSomething();
        concreteClass1.templateMethod();
        ConcreteClass2 concreteClass2 = new ConcreteClass2();
        concreteClass1.templateMethod();
        concreteClass2.doAnything();
        concreteClass2.doSomething();

    }
}
