package homeworks.homework19_5;

import homeworks.homework19_5.dto.CreateUpdateTelevisionRequest;
import homeworks.homework19_5.service.TelevisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("homework19_5")
class TvServiceAopTest {

    @Autowired
    TelevisionService service;

    @Test
    void create_whenTooHighPrice_shouldThrow() {
        var req = new CreateUpdateTelevisionRequest(
                "Brand", "Model", 55, "4K", "QLED", true, new BigDecimal("2000000"), 2024
        );
        assertThatThrownBy(() -> service.create(req))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Price too high");
    }

    @Test
    void create_whenNegativePrice_shouldThrow() {
        var req = new CreateUpdateTelevisionRequest(
                "Brand", "Model", 55, "4K", "QLED", true, new BigDecimal("-1"), 2024
        );
        assertThatThrownBy(() -> service.create(req))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("positive");
    }
}
