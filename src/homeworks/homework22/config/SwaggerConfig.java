package homeworks.homework22.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TV Store API")
                        .version("1.0")
                        .description("REST API для управления каталогом телевизоров")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your.email@example.com")));
    }
}