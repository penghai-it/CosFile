package it.ph.com.cosfiletest.mode.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述: 员工实体
 */
@Data
@TableName(value = "staff")
public class StaffMode {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private int age;
    @TableField(value = "sex")
    private int sex;
    @TableField(value = "salary")
    private BigDecimal salary;
}
