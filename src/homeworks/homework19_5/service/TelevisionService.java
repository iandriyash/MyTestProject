package homeworks.homework19_5.service;

import homeworks.homework19_5.aop.CheckPrice;
import homeworks.homework19_5.dto.CreateUpdateTelevisionRequest;
import homeworks.homework19_5.entity.Television;
import homeworks.homework19_5.repository.TelevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelevisionService {

    private final TelevisionRepository repository;

    public List<Television> findAll() {
        return repository.findAll();
    }

    public Television findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TV not found: " + id));
    }

    @CheckPrice
    public Television create(CreateUpdateTelevisionRequest r) {
        Television tv = Television.builder()
                .brand(r.brand())
                .model(r.model())
                .sizeInches(r.sizeInches())
                .resolution(r.resolution())
                .panelType(r.panelType())
                .smart(Boolean.TRUE.equals(r.smart()))
                .price(r.price())
                .year(r.year())
                .build();
        return repository.save(tv);
    }

    @CheckPrice
    public Television update(Long id, CreateUpdateTelevisionRequest r) {
        Television tv = findById(id);
        tv.setBrand(r.brand());
        tv.setModel(r.model());
        tv.setSizeInches(r.sizeInches());
        tv.setResolution(r.resolution());
        tv.setPanelType(r.panelType());
        tv.setSmart(Boolean.TRUE.equals(r.smart()));
        tv.setPrice(r.price());
        tv.setYear(r.year());
        return repository.save(tv);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
