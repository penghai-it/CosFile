package it.ph.com.cosfiletest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import it.ph.com.cosfiletest.config.LoginInfoConfig;
import it.ph.com.cosfiletest.mapper.StaffMapper;
import it.ph.com.cosfiletest.mode.vo.StaffMode;
import it.ph.com.cosfiletest.service.StaffServicer;
import it.ph.com.cosfiletest.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述:
 */
@Service
public class StaffServiceImpl implements StaffServicer {
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    LoginInfoConfig loginInfoConfig;
    public static final ExecutorService executorService = Executors.newFixedThreadPool(10000);

    @Override
    public List<StaffMode> get() {
        ThreadLocalUtils.setTableName("1");
        QueryWrapper<StaffMode> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        return staffMapper.selectList(queryWrapper);
    }

    @Override
    public StaffMode getById(Integer id) {
        return staffMapper.selectById(id);
    }

    @Override
    public int update(StaffMode staffMode) {
        ThreadLocalUtils.setTableName("1");
        UpdateWrapper<StaffMode> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("name", staffMode.getName());
        updateWrapper.set("age", staffMode.getAge());
        updateWrapper.set("sex", staffMode.getSex());
        //updateWrapper.setSql("salary = salary - " + staffMode.getSalary());
        updateWrapper.set("salary", staffMode.getSalary());
        ///updateWrapper.set("tableName", "staff_1");
        updateWrapper.eq("id", staffMode.getId());
        return staffMapper.update(staffMode, updateWrapper);
    }

    @Override
    public int insert(StaffMode staffMode) {
        //异步执行
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //使用线程池多线程执行
            executorService.execute(new InsertTask(staffMode, staffMapper));
        });
        System.err.println("1111");
        return 1;
    }

    @Override
    public int delete(Integer id) {
        UpdateWrapper<StaffMode> updateWrappe = new UpdateWrapper<>();
        updateWrappe.eq("id", id);
        return staffMapper.delete(updateWrappe);
    }

    @Override
    public int sync() {
        QueryWrapper<StaffMode> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        List<StaffMode> staffModes = staffMapper.selectList(queryWrapper);
        int[] results;
        try {
            // 导入JDBC驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接要读取数据的数据库
            Connection conn1 = DriverManager.getConnection("jdbc:mysql://" + loginInfoConfig.HOSTANDPORT + "/user", loginInfoConfig.USERNAME, loginInfoConfig.PASSWORD);
            // 批量插入数据
            String sql = "insert into staff (id,name,age,sex,salary) values (?,?,?,?,?)";
            PreparedStatement stmt = conn1.prepareStatement(sql);
            for (StaffMode staffMode : staffModes) {
                stmt.setInt(1, staffMode.getId());
                stmt.setString(2, staffMode.getName());
                stmt.setInt(3, staffMode.getAge());
                stmt.setInt(4, staffMode.getSex());
                stmt.setBigDecimal(5, staffMode.getSalary());
                stmt.addBatch();
            }
            // 执行批处理
            results = stmt.executeBatch();
            stmt.close();
            conn1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return results.length;
    }

    @Override
    public int insert2(StaffMode staffMode) {
        staffMapper.insert(staffMode);
        return 1;
    }
}
