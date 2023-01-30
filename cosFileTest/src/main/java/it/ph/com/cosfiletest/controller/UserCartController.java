package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.mode.Cart;
import it.ph.com.cosfiletest.mode.vo.NormalUserCartVo;
import it.ph.com.cosfiletest.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 用户购物车接口层
 */
@RestController
@RequestMapping("cart")
public class UserCartController {
    @Autowired
    UserCartService userCartService;

    /**
     * @param normalUserCartVo 用户和商品信息Vo
     * @return: it.ph.com.cosfiletest.mode.Cart
     * @创建者: PH
     * @时间: 2022/11/28
     * @描述: 普通用户购物车处理过接口
     **/
    @PostMapping("/normalUserCart")
    public Cart normalUserCart(@RequestBody NormalUserCartVo normalUserCartVo) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(normalUserCartVo.getItemId(),normalUserCartVo.getItemQuantity());
        return userCartService.normalUserCart(normalUserCartVo.getUserId(), map);
    }
}
