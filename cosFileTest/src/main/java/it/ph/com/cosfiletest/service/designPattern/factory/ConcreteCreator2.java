package it.ph.com.cosfiletest.service.designPattern.factory;

import it.ph.com.cosfiletest.mode.UserTest;

/**
 * @author PH
 * @时间： 2023/1/30
 * @描述：具体的产品类
 */
public class ConcreteCreator2 extends Product {
    @Override
    public void model2(UserTest userTest) {
        System.out.println("具体产品2的结果 userTest=" + userTest);
        //业务逻辑处理
    }
}
