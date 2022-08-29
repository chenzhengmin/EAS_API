package czm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "czm.mapper")
@SpringBootApplication
public class EasPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasPortalApplication.class, args);
    }

}
