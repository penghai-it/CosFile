package it.ph.com.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：
 */
public interface Testsss {

    // @Insert("insert into user values (1,'测试',2,3)")
    @Delete("delete from 'user' where id = '1'")
    void test();

    @Insert("insert into userpost values (1,2,'测试2','测试3')")
    void tsttwo();
}
