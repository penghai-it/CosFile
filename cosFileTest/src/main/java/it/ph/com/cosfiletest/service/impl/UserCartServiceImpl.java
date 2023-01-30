package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mapper.CartMapper;
import it.ph.com.cosfiletest.mapper.ItemMapper;
import it.ph.com.cosfiletest.mode.Cart;
import it.ph.com.cosfiletest.mode.Item;
import it.ph.com.cosfiletest.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述：购物车处理过程业务层
 */
@Service
public class UserCartServiceImpl implements UserCartService {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    CartMapper cartMapper;

    @Override
    public Cart normalUserCart(long userId, Map<Long, Integer> items) {
        Cart cart = new Cart();
        //把Map的购物车转换为Item列表
        List<Item> itemList = new ArrayList<>();
        items.forEach((key, value) -> {
            Item item = new Item();
            item.setId(key);
            item.setPrice(new BigDecimal(String.valueOf((Math.random() * (200 - 100))) + 100));
            item.setQuantity(value);
            itemList.add(item);

        });
        cart.setItems(itemList);
        //处理运费和商品优惠
        itemList.forEach(item -> {
            //运费为商品总价的10%(代码的意思==>商品运费=商品价格x(商品数量x0.1))
            item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).multiply(new BigDecimal("0.1")));
            //无优惠
            item.setCouponPrice(BigDecimal.ZERO);
            itemMapper.insert(item);
        });
        //计算商品总价 reduce(BigDecimal.ZERO,BigDecimal::add))的第一个参数表示初始值，从0开始相加
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算运费总价
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算总优惠
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //应付总价=商品总价+运费总价-总优惠
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        cartMapper.insert(cart);

        return cart;

    }
}
