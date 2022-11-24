package it.ph.com.cosfiletest.mode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author PH
 * @时间： 2022/11/23
 * @描述：领取表Mode
 */
@Data
@TableName(value = "test_receive")
public class ReceiveMode {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "userName")
    private String userName;
    /**
     * 创建时间
     */
    @TableField(value = "creationTime")
    private Date creationTime;
    /**
     * 物品id
     */
    @TableField(value = "balanceId")
    private int balanceId;
    /**
     * 领取数量
     */
    @TableField(value = "quantityReceived")
    private int quantityReceived;
}
