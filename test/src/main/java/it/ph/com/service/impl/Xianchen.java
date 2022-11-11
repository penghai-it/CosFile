package it.ph.com.service.impl;

import it.ph.com.service.Testsss;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：
 */
public class Xianchen implements Runnable {
    @Autowired
    private Testsss testsss;

    @Override
    public void run() {
        testsss.tsttwo();
    }
}
