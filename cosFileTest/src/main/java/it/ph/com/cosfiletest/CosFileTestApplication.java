package it.ph.com.cosfiletest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("it.ph.com.cosfiletest.mapper")
public class CosFileTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosFileTestApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  部署测试服务，启动成功   ლ(´ڡ`ლ)ﾞ  \n" + " .-------.       ____     __        \n" + " |  _ _   \\      \\   \\   /  /    \n" + " | ( ' )  |       \\  _. /  '       \n" + " |(_ o _) /        _( )_ .'         \n" + " | (_,_).' __  ___(_ o _)'          \n" + " |  |\\ \\  |  ||   |(_,_)'         \n" + " |  | \\ `'   /|   `-'  /           \n" + " |  |  \\    /  \\      /           \n" + " ''-'   `'-'    `-..-'              ");
    }

}
