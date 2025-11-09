package homeworks.homework23;

import homeworks.homework22.entity.Tv;
import homeworks.homework22.repository.TvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
class TvRepositoryTest {

    @Container
    static PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", pg::getJdbcUrl);
        r.add("spring.datasource.username", pg::getUsername);
        r.add("spring.datasource.password", pg::getPassword);
    }

    @Autowired TvRepository repo;

    @Test
    void findByBrand_returnsEntities() {
        repo.save(new Tv(null, "Samsung", "QN90A", 55, new BigDecimal("89990.00"), true, null));
        repo.save(new Tv(null, "Samsung", "Q80C", 65, new BigDecimal("99990.00"), true, null));

        List<Tv> samsungs = repo.findByBrand("Samsung");
        assertThat(samsungs).hasSize(2);
    }
}
