package homeworks.homework22.service;

import homeworks.homework22.entity.Tv;
import homeworks.homework22.repository.TvRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class TvService {

    private final TvRepository tvRepository;

    public List<Tv> findAll() {
        log.info("Получение всех телевизоров");
        return tvRepository.findAll();
    }

    public Optional<Tv> findById(Long id) {
        log.info("Получение телевизора по ID: {}", id);
        return tvRepository.findById(id);
    }

    public List<Tv> findByBrand(String brand) {
        log.info("Поиск телевизоров по бренду: {}", brand);
        return tvRepository.findByBrand(brand);
    }

    public List<Tv> findByIsSmart(Boolean isSmart) {
        log.info("Поиск Smart TV: {}", isSmart);
        return tvRepository.findByIsSmart(isSmart);
    }

    @Transactional
    public Tv save(Tv tv) {
        log.info("Сохранение телевизора: {}", tv.getBrand());
        return tvRepository.save(tv);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Удаление телевизора ID: {}", id);
        tvRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return tvRepository.existsById(id);
    }

    // ----- Асинхронный метод для демонстрации многопоточности -----
    @Async
    public CompletableFuture<List<Tv>> findAllAsync() {
        log.info("Асинхронное получение списка телевизоров");
        // В @Async-методе не используем supplyAsync, чтобы не обходить Spring TaskExecutor
        List<Tv> list = findAll();
        return CompletableFuture.completedFuture(list);
    }
}
