package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.mode.BalanceMode;
import it.ph.com.cosfiletest.service.MyBatisAndThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PH
 * @时间： 2022/11/23
 * @描述： 多线程（锁）测试接口层
 */
@RestController
@RequestMapping("api")
public class MyBatisAndThreadController {
    @Autowired
    MyBatisAndThreadService myBatisAndThreadService;

    /**
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 插入数据到优惠卷表
     **/
    @PostMapping("/insert")
    public int insert(BalanceMode balanceMode) {
        return myBatisAndThreadService.insert(balanceMode);
    }

    /**
     * @return: java.util.List<it.ph.com.cosfiletest.mode.BalanceMode>
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 查询优惠卷数据列表
     **/
    @GetMapping("/select")
    public List<BalanceMode> select() {
        return myBatisAndThreadService.select();
    }

    /**
     * @param balanceMode 优惠卷数据对象
     * @return: java.lang.Integer
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 更新优惠卷数据
     **/
    @PostMapping("update")
    public Integer update(BalanceMode balanceMode) {
        return myBatisAndThreadService.update(balanceMode);
    }

    /**
     * @param quantity 领取数量
     *@param id 优惠卷id
     * @return: java.lang.String
     * @创建者: PH
     * @时间: 2022/11/23
     * @描述: 领取优惠卷
     **/
    @GetMapping("collarRoll/{quantity}/{id}")
    public String collarRollController(@PathVariable int quantity, @PathVariable int id) {
        return myBatisAndThreadService.collarRollServicer(quantity, id);
    }
}
