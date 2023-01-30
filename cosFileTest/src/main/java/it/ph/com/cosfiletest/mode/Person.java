package it.ph.com.cosfiletest.mode;

import lombok.Data;

/**
 * @author PH
 * @时间： 2022/11/28
 * @描述： 员工类
 */
@Data
public class Person {
    // 姓名
    private String name;
    // 薪资
    private int salary;
    // 年龄
    private int age;
    //性别
    private String sex;
    // 地区
    private String area;

    // 构造方法
    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
}
