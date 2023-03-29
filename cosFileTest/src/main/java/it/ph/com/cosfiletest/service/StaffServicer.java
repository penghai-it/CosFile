package it.ph.com.cosfiletest.service;

import it.ph.com.cosfiletest.mode.vo.StaffMode;

import java.util.List;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述:
 */
public interface StaffServicer {
    List<StaffMode> get();

    StaffMode getById(Integer id);

    int update(StaffMode staffMode);

    int insert(StaffMode staffMode);

    int delete(Integer id);

    int sync();

    int insert2(StaffMode staffMode);
}
