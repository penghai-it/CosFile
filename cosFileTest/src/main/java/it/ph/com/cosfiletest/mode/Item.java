package it.ph.com.cosfiletest.mode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 购物车中的商品
 */
@Data
@TableName(value = "item")
public class Item {
    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品数量
     */
    @TableField(value = "quantity")
    private int quantity;
    /**
     * 商品单价
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 商品优惠
     */
    @TableField(value = "couponPrice")
    private BigDecimal couponPrice;
    /**
     * 商品运费
     */
    @TableField(value = "deliveryPrice")
    private BigDecimal deliveryPrice;
}
