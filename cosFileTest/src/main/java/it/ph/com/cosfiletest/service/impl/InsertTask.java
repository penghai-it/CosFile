package it.ph.com.cosfiletest.service.impl;

import it.ph.com.cosfiletest.mapper.StaffMapper;
import it.ph.com.cosfiletest.mode.vo.StaffMode;

/**
 * @author: P H
 * @时间: 2023/3/28
 * @描述:
 */
public class InsertTask implements Runnable {
    StaffMapper staffMapper;

    private StaffMode staffMode;

    public InsertTask(StaffMode staffMode, StaffMapper staffMapper) {
        this.staffMode = staffMode;
        this.staffMapper = staffMapper;
        System.err.println("222");
    }

    @Override
    public void run() {
        staffMapper.insert(staffMode);
    }
}
