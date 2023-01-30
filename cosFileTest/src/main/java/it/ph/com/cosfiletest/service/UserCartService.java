package it.ph.com.cosfiletest.service;

import it.ph.com.cosfiletest.mode.Cart;

import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 普通用户购物车处理
 */
public interface UserCartService {
    /**
     * @param userId 用户id
     * @param items  商品信息 <商品id,商品数量>
     * @return: it.ph.com.cosfiletest.mode.Cart
     * @创建者: PH
     * @时间: 2022/11/28
     * @描述: 普通用户购物车处理过程
     **/
    Cart normalUserCart(long userId, Map<Long, Integer> items);
}
