package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.test.Geme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: P H
 * @时间: 2023/2/22
 * @描述: 游戏测试接口
 */
@RestController
@RequestMapping("api/test")
public class GameController {
    @Autowired
    Geme geme;

    @GetMapping("gameTest")
    public Map<String, List<String>> geamTest() {
        return geme.pokerGame();
    }
}
