package homeworks.homework21.controller;

import homeworks.homework21.dto.TvDto;
import homeworks.homework21.service.TvService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tvs")
@RequiredArgsConstructor
@Slf4j
public class TvController {

    private final TvService tvService;

    @GetMapping
    public ResponseEntity<List<TvDto>> getAllTvs() {
        log.info("GET /api/tvs - Получение всех телевизоров");
        return ResponseEntity.ok(tvService.getAllTvs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TvDto> getTvById(@PathVariable Long id) {
        log.info("GET /api/tvs/{} - Получение телевизора по ID", id);
        try {
            return ResponseEntity.ok(tvService.getTvById(id));
        } catch (RuntimeException e) {
            log.error("Телевизор с ID {} не найден", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<TvDto>> searchTvs(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Boolean smart) {
        log.info("GET /api/tvs/search - Поиск (brand={}, smart={})", brand, smart);

        if (brand != null) {
            return ResponseEntity.ok(tvService.getTvsByBrand(brand));
        }
        if (smart != null) {
            return ResponseEntity.ok(tvService.getSmartTvs(smart));
        }
        return ResponseEntity.ok(tvService.getAllTvs());
    }

    @PostMapping
    public ResponseEntity<TvDto> createTv(@RequestBody TvDto tvDto) {
        log.info("POST /api/tvs - Создание нового телевизора");
        TvDto created = tvService.createTv(tvDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TvDto> updateTv(@PathVariable Long id, @RequestBody TvDto tvDto) {
        log.info("PUT /api/tvs/{} - Обновление телевизора", id);
        try {
            TvDto updated = tvService.updateTv(id, tvDto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            log.error("Телевизор с ID {} не найден", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTv(@PathVariable Long id) {
        log.info("DELETE /api/tvs/{} - Удаление телевизора", id);
        try {
            tvService.deleteTv(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Телевизор с ID {} не найден", id);
            return ResponseEntity.notFound().build();
        }
    }
}