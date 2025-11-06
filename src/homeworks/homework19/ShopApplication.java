package homework19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "homework19");
        SpringApplication.run(ShopApplication.class, args);
    }
}