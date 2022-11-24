package it.ph.com.cosfiletest.mode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author PH
 * @时间： 2022/11/23
 * @描述：优惠卷Mode
 */

/**
 * 用于标识实体类对应的表
 */
@TableName(value = "test_balance")
@Data
public class BalanceMode {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 物品名称
     */
    @TableField(value = "itemName")
    private String itemName;
    /**
     * 已发放数量
     */
    @TableField(value = "sent")
    private int sent;
    /**
     * 剩余数量
     */
    @TableField(value = "surplus")
    private int surplus;
    /**
     * 总数量
     */
    @TableField(value = "total")
    private int total;
}
