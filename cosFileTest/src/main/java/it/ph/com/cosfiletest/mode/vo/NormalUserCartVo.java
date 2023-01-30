package it.ph.com.cosfiletest.mode.vo;

import lombok.Data;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述：普通用户购物车Vo
 */
@Data
public class NormalUserCartVo {
    //用户id
    private Long userId;
    //商品id
    private Long itemId;
    //商品数量
    private Integer itemQuantity;
}
