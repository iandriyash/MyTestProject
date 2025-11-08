package homeworks.homework22.config;

import homeworks.homework22.entity.Tv;
import homeworks.homework22.service.TvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final TvService tvService;

    @Override
    public void run(String... args) {
        log.info("=== Загрузка тестовых данных для Телевизоров ===");

        Tv tv1 = new Tv(null, "Samsung", "QN90A", 55, new BigDecimal("89990.00"), true, null);
        Tv tv2 = new Tv(null, "LG", "OLED C1", 65, new BigDecimal("129990.00"), true, null);
        Tv tv3 = new Tv(null, "Sony", "X90J", 50, new BigDecimal("69990.00"), true, null);
        Tv tv4 = new Tv(null, "Xiaomi", "Mi TV P1", 43, new BigDecimal("29990.00"), true, null);
        Tv tv5 = new Tv(null, "Philips", "5500 Series", 32, new BigDecimal("19990.00"), false, null);

        tvService.save(tv1);
        tvService.save(tv2);
        tvService.save(tv3);
        tvService.save(tv4);
        tvService.save(tv5);

        log.info("Создано телевизоров: 5");
        log.info("=== Загрузка завершена ===");
    }
}