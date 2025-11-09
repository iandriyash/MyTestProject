package homeworks.homework22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "homeworks.homework22.entity")
@EnableAsync
public class TvApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "homework22");
        SpringApplication.run(TvApplication.class, args);
    }
}
