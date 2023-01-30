package it.ph.com.cosfiletest.mode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 购物车
 */
@Data
@TableName(value = "cart")
public class Cart {
    /**
     * 商品清单
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品信息集合(注解表示该属性不是数据字段)
     */
    @TableField(exist = false)
    private List<Item> items = new ArrayList<>();
    /**
     * 总优惠
     */
    @TableField(value = "totalDiscount")
    private BigDecimal totalDiscount;
    /**
     * 商品总价
     */
    @TableField(value = "totalItemPrice")
    private BigDecimal totalItemPrice;
    /**
     * 总运费
     */
    @TableField(value = "totalDeliveryPrice")
    private BigDecimal totalDeliveryPrice;
    /**
     * 应付总价
     */
    @TableField(value = "payPrice")
    private BigDecimal payPrice;

}
