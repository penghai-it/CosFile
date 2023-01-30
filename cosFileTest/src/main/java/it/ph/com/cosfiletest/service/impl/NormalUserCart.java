package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mode.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author PH
 * @时间： 2022/12/12
 * @描述： 普通用户的购物车方法实现
 */
@Service(value = "NormalUserCart")
public class NormalUserCart extends AbstractCart {
    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 商品优惠处理逻辑
     **/
    @Override
    protected void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 运费处理逻辑
     **/

    @Override
    protected void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()).multiply(new BigDecimal("0.1"))));
    }
}
