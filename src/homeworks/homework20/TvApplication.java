package homework20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TvApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "homework20");
        SpringApplication.run(TvApplication.class, args);
    }
}