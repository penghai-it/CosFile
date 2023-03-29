package it.ph.com.cosfiletest.service.templateMode;

/**
 * @author: P H
 * @时间: 2023/1/31
 * @描述: 具体的模板类1
 */
public class ConcreteClass1 extends AbstractClass {
    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/1/31
     * @描述: 实现基本方法
     **/

    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass1的doSomething()方法被调用了");
        //业务逻辑处理
    }

    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/1/31
     * @描述: 实现基本方法
     **/
    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass1的doAnything()方法被调用了");
        //业务逻辑处理
    }
}
