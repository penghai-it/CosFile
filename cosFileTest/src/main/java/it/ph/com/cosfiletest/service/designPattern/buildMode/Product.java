package it.ph.com.cosfiletest.service.designPattern.buildMode;

import lombok.Data;

/**
 * @author: P H
 * @时间: 2023/2/1
 * @描述: 产品类（建造者模式）
 */
@Data
public class Product {
    private Long id;
    private String name;
    private double price;

    public void doSomething() {
        //独立业务处理
    }
}
