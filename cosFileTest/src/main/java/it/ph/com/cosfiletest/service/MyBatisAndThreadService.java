package it.ph.com.cosfiletest.service;

import it.ph.com.cosfiletest.mode.BalanceMode;

import java.util.List;

/**
 * @author PH
 * @时间： 2022/11/23
 * @描述： 测试多线程锁
 */
public interface MyBatisAndThreadService {
    /**
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 插入数据到优惠卷表
     **/
    int insert(BalanceMode balanceMode);

    /**
     * @return: java.util.List<it.ph.com.cosfiletest.mode.BalanceMode>
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 查询优惠卷数据列表
     **/
    List<BalanceMode> select();

    /**
     * @param balanceMode 优惠卷数据对象
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 更新优惠卷数据
     **/
    Integer update(BalanceMode balanceMode);

    /**
     * @param quantity 优惠卷数量
     * @param id       优惠卷id
     * @return: java.lang.String
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 领取优惠卷
     **/
    String collarRollServicer(int quantity, int id);
}
