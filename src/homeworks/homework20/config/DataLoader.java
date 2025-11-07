package homework20.config;

import homework20.dto.TvDto;
import homework20.service.TvService;
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

        TvDto tv1 = new TvDto(null, "Samsung", "QN90A", 55, BigDecimal.valueOf(89990), true, null);
        TvDto tv2 = new TvDto(null, "LG", "OLED C1", 65, BigDecimal.valueOf(129990), true, null);
        TvDto tv3 = new TvDto(null, "Sony", "X90J", 50, BigDecimal.valueOf(69990), true, null);
        TvDto tv4 = new TvDto(null, "Xiaomi", "Mi TV P1", 43, BigDecimal.valueOf(29990), true, null);
        TvDto tv5 = new TvDto(null, "Philips", "5500 Series", 32, BigDecimal.valueOf(19990), false, null);

        tvService.createTv(tv1);
        tvService.createTv(tv2);
        tvService.createTv(tv3);
        tvService.createTv(tv4);
        tvService.createTv(tv5);

        log.info("Создано телевизоров: 5");

        log.info("\n=== Тестирование CRUD операций ===");
        log.info("Всего телевизоров: {}", tvService.getAllTvs().size());
        log.info("Телевизоры Samsung: {}", tvService.getTvsByBrand("Samsung").size());
        log.info("Smart TV: {}", tvService.getSmartTvs(true).size());

        log.info("=== Загрузка завершена ===\n");
    }
}