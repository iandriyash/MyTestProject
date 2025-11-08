package homeworks.homework22.controller;

import homeworks.homework22.entity.Tv;
import homeworks.homework22.service.TvService;
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
    public ResponseEntity<List<Tv>> getAllTvs() {
        log.info("GET /api/tvs - получение всех телевизоров");
        List<Tv> tvs = tvService.findAll();
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tv> getTvById(@PathVariable Long id) {
        log.info("GET /api/tvs/{} - получение телевизора по ID", id);
        return tvService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tv> createTv(@RequestBody Tv tv) {
        log.info("POST /api/tvs - создание нового телевизора: {}", tv.getBrand());
        Tv savedTv = tvService.save(tv);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tv> updateTv(@PathVariable Long id, @RequestBody Tv tv) {
        log.info("PUT /api/tvs/{} - обновление телевизора", id);
        return tvService.findById(id)
                .map(existingTv -> {
                    tv.setId(id);
                    Tv updatedTv = tvService.save(tv);
                    return ResponseEntity.ok(updatedTv);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTv(@PathVariable Long id) {
        log.info("DELETE /api/tvs/{} - удаление телевизора", id);
        tvService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Tv>> getTvsByBrand(@PathVariable String brand) {
        log.info("GET /api/tvs/brand/{} - поиск по бренду", brand);
        List<Tv> tvs = tvService.findByBrand(brand);
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/smart")
    public ResponseEntity<List<Tv>> getSmartTvs() {
        log.info("GET /api/tvs/smart - поиск Smart TV");
        List<Tv> smartTvs = tvService.findByIsSmart(true);
        return ResponseEntity.ok(smartTvs);
    }
}