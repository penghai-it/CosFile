package it.ph.com.cosfiletest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import it.ph.com.cosfiletest.mode.BalanceMode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BalanceMapper extends BaseMapper<BalanceMode> {

    /**
     * @param balanceMode 优惠卷数据对象
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 插入数据到优惠卷表
     **/
    @Insert("INSERT INTO test_balance (id,itemName,sent,surplus,total) VALUES (#{balanceMode.id},#{balanceMode.itemName},#{balanceMode.sent},#{balanceMode.surplus},#{balanceMode.total})")
    int insert(@Param("balanceMode") BalanceMode balanceMode);


    /**
     * @return: java.util.List<it.ph.com.cosfiletest.mode.BalanceMode>
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 查询优惠卷数据列表
     **/


    @Select("SELECT * FROM test_balance")
    List<BalanceMode> select();


    /**
     * @param balanceMode 优惠卷数据对象
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 修改优惠卷数据
     **/
    @Update("UPDATE test_balance SET itemName=#{balanceMode.itemName},sent=#{balanceMode.sent},surplus=#{balanceMode.surplus},total=#{balanceMode.total} WHERE id=#{balanceMode.id}")
    Integer update(@Param("balanceMode") BalanceMode balanceMode);


    /**
     * @param id 优惠卷id
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 获取优惠卷剩余数量
     **/


    @Select("SELECT surplus FROM test_balance WHERE id=#{id}")
    int getSurplus(@Param("id") int id);

    /**
     * @param quantity 领取数量
     * @param id       优惠卷id
     * @return: int
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 更新优惠卷剩余数量
     **/


    @Update("update test_balance set surplus=surplus-#{quantity},sent=sent+#{quantity} WHERE id=#{id}")
    int updateSurplus(@Param("quantity") int quantity, @Param("id") int id);
}

