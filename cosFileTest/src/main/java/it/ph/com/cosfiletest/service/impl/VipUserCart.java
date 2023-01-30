package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mapper.ItemMapper;
import it.ph.com.cosfiletest.mode.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PH
 * @时间： 2022/12/12
 * @描述： VIP用户的购物车方法实现
 */
@Service(value = "VipUserCart")
public class VipUserCart extends NormalUserCart {
    @Autowired
    ItemMapper itemMapper;

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
    /*    if (item.getQuantity() > 2) {
            item.setCouponPrice(item.getPrice().multiply(BigDecimal.valueOf(100 - itemMapper.selectById(item.getId()).getCouponPrice()).divide(new BigDecimal("100"))).multiply(BigDecimal.valueOf(item.getQuantity() - 2)));
        }
*/

    }
}
