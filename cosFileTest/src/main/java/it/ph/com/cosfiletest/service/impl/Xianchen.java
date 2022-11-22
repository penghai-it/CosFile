package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.service.Testsss;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：创建一个线程实现MyBatis注解式SQL
 */
public class Xianchen implements Runnable {
    @Autowired
    private Testsss testsss;

    @Override
    public void run() {
        testsss.tsttwo();
    }
}
