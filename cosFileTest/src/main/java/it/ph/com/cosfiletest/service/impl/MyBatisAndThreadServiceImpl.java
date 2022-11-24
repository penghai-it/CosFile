package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mapper.BalanceMapper;
import it.ph.com.cosfiletest.mapper.ReceiveMapper;
import it.ph.com.cosfiletest.mode.BalanceMode;
import it.ph.com.cosfiletest.mode.ReceiveMode;
import it.ph.com.cosfiletest.service.MyBatisAndThreadService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author PH
 * @时间： 2022/11/23
 * @描述：多线程（锁）测试实现类
 */
@Service
public class MyBatisAndThreadServiceImpl implements MyBatisAndThreadService {
    @Autowired
    BalanceMapper balanceMapper;
    @Autowired
    ReceiveMapper receiveMapper;
    @Autowired
    RedissonClient redissonClient;

    @Override
    public int insert(BalanceMode balanceMode) {
        balanceMode.setId(UUID.randomUUID().getLeastSignificantBits());
        return balanceMapper.insert(balanceMode);
    }

    @Override
    public List<BalanceMode> select() {
        return balanceMapper.select();
    }

    @Override
    public Integer update(BalanceMode balanceMode) {
        return balanceMapper.update(balanceMode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String collarRollServicer(int quantity, int id) {
        String key = "lock:coupon:" + id;
        //获取锁对象
        RLock rlock = redissonClient.getLock(key);
        //加锁
        rlock.lock();
        try {
            int surplus = balanceMapper.getSurplus(id);
            //判断优惠卷是否还有优惠卷
            if (surplus <= 0) {
                return "优惠卷已发放完!";
            }
            //更行优惠卷数量
            balanceMapper.updateSurplus(quantity, id);
            ReceiveMode receiveMode = new ReceiveMode();
            receiveMode.setUserName("test");
            receiveMode.setCreationTime(new Date());
            receiveMode.setBalanceId(id);
            receiveMode.setQuantityReceived(quantity);
            receiveMapper.insert(receiveMode);
        } catch (Exception e) {
            throw new RuntimeException("系统异常,请稍后再试!");
        } finally {
            //释放锁
            rlock.unlock();
        }
        return "成功领取" + quantity + "张优惠卷!";
    }
}
