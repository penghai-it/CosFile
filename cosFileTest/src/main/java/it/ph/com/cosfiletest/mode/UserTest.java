package it.ph.com.cosfiletest.mode;

import lombok.Data;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述： 用户信息实体
 */
@Data
public class UserTest {
    private Integer id;
    private String name;
    private Integer age;
    private Integer address;

    private UserTest() {
    }


    private static class UserTestFactory {
        public static UserTest userTest = new UserTest();
    }

    public static UserTest getInstance() {
        return UserTestFactory.userTest;
    }

    public Object readResolve() {
        return getInstance();
    }
}
