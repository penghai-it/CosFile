package it.ph.com.cosfiletest.mode;

import lombok.Data;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：
 */
@Data
public class Userpost {
    private Integer id;
    private Integer userId;
    private String post;
    private String department;
}
