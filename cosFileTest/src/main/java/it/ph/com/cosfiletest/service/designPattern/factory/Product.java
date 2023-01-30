package it.ph.com.cosfiletest.service.designPattern.factory;

import it.ph.com.cosfiletest.mode.UserTest;

/**
 * @author PH
 * @时间： 2023/1/30
 * @描述：工厂方法模式
 */
public abstract class Product {
    /**
     * 产品类的公共方法
     **/
    public void model(UserTest userTest) {
        System.out.println("公共方法：userTest=" + userTest);
        //业务处理
    }

    /**
     * @param userTest 参数
     * @描述:抽象方法
     **/
    public abstract void model2(UserTest userTest);
}
