package it.ph.com.cosfiletest.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PH
 * @时间： 2022/11/24
 * @描述：用户PO
 */
@Data
@AllArgsConstructor
public class UserPo {
    private String name;
    private Double score;

}
