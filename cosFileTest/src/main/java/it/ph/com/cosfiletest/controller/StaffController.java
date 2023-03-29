package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.mode.vo.StaffMode;
import it.ph.com.cosfiletest.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: P H
 * @时间: 2023/3/17
 * @描述:
 */
@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    StaffServiceImpl staffService;

    @GetMapping("/get")
    public List<StaffMode> gte() {
        return staffService.get();
    }

    @PostMapping("/update")
    public int update(StaffMode staffMode) {
        return staffService.update(staffMode);
    }

    @PostMapping("/insert")
    public int insert(StaffMode staffMode) {
        return staffService.insert(staffMode);
    }
    @PostMapping("/insert2")
    public int insert2(StaffMode staffMode) {
        return staffService.insert2(staffMode);
    }
    @GetMapping("delete")
    public int delete(int id) {
        return staffService.delete(id);
    }

    @GetMapping("/sync")
    public int sync() {
        return staffService.sync();
    }

}
