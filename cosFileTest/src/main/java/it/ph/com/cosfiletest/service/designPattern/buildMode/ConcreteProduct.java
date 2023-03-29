package it.ph.com.cosfiletest.service.designPattern.buildMode;

/**
 * @author: P H
 * @时间: 2023/2/1
 * @描述: 具体建造者
 */
public class ConcreteProduct extends Builder {
    private Product product = new Product();

    /**
     * @return: void
     * @创建者: P H
     * @时间: 2023/2/1
     * @描述: 设置产品零件
     **/

    @Override
    public void setPart() {
        product.setId(1L);
        product.setName("零件1");
        product.setPrice(6.8);
        //产品类内的逻辑处理
    }

    /**
     * @return: it.ph.com.cosfiletest.service.designPattern.buildMode.FactoryProduct
     * @创建者: P H
     * @时间: 2023/2/1
     * @描述: 组建一个产品
     **/

    @Override
    public Product buildProduct() {
        return product;
    }
}
