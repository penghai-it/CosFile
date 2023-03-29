package it.ph.com.cosfiletest.service.designPattern.buildMode;

/**
 * @author: P H
 * @时间: 2023/2/1
 * @描述: 抽象建造者
 */
public abstract class Builder {
    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/2/1
     * @描述: 设置产品的不同部分，以获得不同的产品
     **/

    public abstract void setPart();

    /**
     * @return: it.ph.com.cosfiletest.service.designPattern.buildMode.FactoryProduct
     * @创建者: P H
     * @时间: 2023/2/1
     * @描述: 创建产品
     **/

    public abstract Product buildProduct();
}
