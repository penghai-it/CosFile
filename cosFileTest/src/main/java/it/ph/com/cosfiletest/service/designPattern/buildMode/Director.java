package it.ph.com.cosfiletest.service.designPattern.buildMode;

import java.net.URLDecoder;

/**
 * @author: P H
 * @时间: 2023/2/1
 * @描述: 导演类
 */
public class Director {
    private Builder builder = new ConcreteProduct();

    /**
     * @return: it.ph.com.cosfiletest.service.designPattern.buildMode.FactoryProduct
     * @创建者: P H
     * @时间: 2023/2/1
     * @描述: 构建不同的产品
     **/

    public Product getProduct() {
        builder.setPart();
        //设置不同的零件，生产不同的零件
        return builder.buildProduct();
    }

    public static void main(String[] args) {
        System.out.println(URLDecoder.decode("%7B%22input5%22%3A%22%22%2C%22input4%22%3A%22%22%2C%22input3%22%3A%22%22%2C%22input2%22%3A%22%22%2C%22input1%22%3A%227615477259313153%22%7D"));
    }
}
