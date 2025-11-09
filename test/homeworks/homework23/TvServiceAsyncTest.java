package homeworks.homework23;

import homeworks.homework22.TvApplication;
import homeworks.homework22.entity.Tv;
import homeworks.homework22.repository.TvRepository;
import homeworks.homework22.service.TvService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TvApplication.class)
@Testcontainers
class TvServiceAsyncTest {

    @Container
    static PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", pg::getJdbcUrl);
        r.add("spring.datasource.username", pg::getUsername);
        r.add("spring.datasource.password", pg::getPassword);
    }

    @Autowired TvService service;
    @Autowired TvRepository repo;

    @Test
    void findAllAsync_returnsResult() throws Exception {
        // ВАЖНО: соблюдаем NOT NULL поля сущности
        repo.save(new Tv(null, "TestBrand", "TestModel", 42, new BigDecimal("12345.00"), true, null));

        var cf = service.findAllAsync();
        var result = cf.get(5, TimeUnit.SECONDS);
        assertThat(result).isNotEmpty();
    }
}
