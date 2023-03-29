package it.ph.com.cosfiletest.service.templateMode;

/**
 * @author: P H
 * @时间: 2023/1/31
 * @描述: 抽象模板类（模板模式）
 */
public abstract class AbstractClass {
    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/1/31
     * @描述: 基本方法
     **/

    protected abstract void doSomething();

    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/1/31
     * @描述: 基本方法
     **/

    protected abstract void doAnything();

    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/1/31
     * @描述: 模板方法
     **/

    public void templateMethod() {
        //调用基本方法，完成相关的逻辑
        this.doSomething();
        this.doAnything();
    }

}
