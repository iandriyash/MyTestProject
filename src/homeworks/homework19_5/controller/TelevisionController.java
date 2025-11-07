package homeworks.homework19_5.controller;

import homeworks.homework19_5.dto.CreateUpdateTelevisionRequest;
import homeworks.homework19_5.entity.Television;
import homeworks.homework19_5.service.TelevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tv")
@RequiredArgsConstructor
public class TelevisionController {

    private final TelevisionService service;

    @GetMapping
    public List<Television> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Television byId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Television> create(@RequestBody CreateUpdateTelevisionRequest req) {
        Television saved = service.create(req);
        return ResponseEntity.created(URI.create("/api/tv/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public Television update(@PathVariable Long id, @RequestBody CreateUpdateTelevisionRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
