package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mode.Cart;
import it.ph.com.cosfiletest.mode.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 模板方法模式_购物车抽象实现类
 */

public abstract class AbstractCart {
    /**
     * @param userId 用户id
     * @param items  购物车信息
     * @return: it.ph.com.cosfiletest.mode.Cart
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 购物车抽象实现方法
     **/

    public Cart process(long userId, Map<Long, Integer> items) {
        Cart cart = new Cart();
        List<Item> itemList = new ArrayList<>();
        items.forEach((key, value) -> {
            Item item = new Item();
            item.setId(key);
            item.setPrice(new BigDecimal(String.valueOf((Math.random() * (200 - 100))) + 100));
            item.setQuantity(value);
            itemList.add(item);
        });
        cart.setItems(itemList);
        //让子类处理每一个商品的优惠
        itemList.forEach(item -> {
            processCouponPrice(userId, item);
            processDeliveryPrice(userId, item);
        });
        //计算商品总价
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算总运费
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算总折扣
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算应付价格
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }

    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 处理商品优惠的逻辑留给子类实现
     **/

    protected abstract void processCouponPrice(long userId, Item item);

    /**
     * @param userId 用户id
     * @param item   购物车信息
     * @return: void
     * @创建者: PH
     * @时间: 2022/12/12
     * @描述: 处理配送费的逻辑留给子类实现
     **/
    protected abstract void processDeliveryPrice(long userId, Item item);


}
