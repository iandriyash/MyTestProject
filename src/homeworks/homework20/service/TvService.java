package homework20.service;

import homework20.dto.TvDto;
import homework20.entity.TV;
import homework20.repository.TvRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TvService {

    private final TvRepository tvRepository;

    public List<TvDto> getAllTvs() {
        log.info("Получение всех телевизоров");
        return tvRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public TvDto getTvById(Long id) {
        log.info("Получение телевизора по ID: {}", id);
        TV tv = tvRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Телевизор не найден с ID: " + id));
        return toDto(tv);
    }

    public List<TvDto> getTvsByBrand(String brand) {
        log.info("Поиск телевизоров по бренду: {}", brand);
        return tvRepository.findByBrand(brand).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<TvDto> getSmartTvs(Boolean isSmart) {
        log.info("Поиск Smart TV: {}", isSmart);
        return tvRepository.findByIsSmart(isSmart).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TvDto createTv(TvDto tvDto) {
        log.info("Создание нового телевизора: {}", tvDto.getBrand());
        TV tv = toEntity(tvDto);
        TV savedTv = tvRepository.save(tv);
        return toDto(savedTv);
    }

    @Transactional
    public TvDto updateTv(Long id, TvDto tvDto) {
        log.info("Обновление телевизора ID: {}", id);
        TV tv = tvRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Телевизор не найден с ID: " + id));

        tv.setBrand(tvDto.getBrand());
        tv.setModel(tvDto.getModel());
        tv.setScreenSize(tvDto.getScreenSize());
        tv.setPrice(tvDto.getPrice());
        tv.setIsSmart(tvDto.getIsSmart());

        TV updatedTv = tvRepository.save(tv);
        return toDto(updatedTv);
    }

    @Transactional
    public void deleteTv(Long id) {
        log.info("Удаление телевизора ID: {}", id);
        if (!tvRepository.existsById(id)) {
            throw new RuntimeException("Телевизор не найден с ID: " + id);
        }
        tvRepository.deleteById(id);
    }

    private TvDto toDto(TV tv) {
        return new TvDto(
                tv.getId(),
                tv.getBrand(),
                tv.getModel(),
                tv.getScreenSize(),
                tv.getPrice(),
                tv.getIsSmart(),
                tv.getCreatedAt()
        );
    }

    private TV toEntity(TvDto dto) {
        return new TV(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getScreenSize(),
                dto.getPrice(),
                dto.getIsSmart(),
                dto.getCreatedAt()
        );
    }
}