package homeworks.homework21.repository;

import homeworks.homework21.entity.TV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvRepository extends JpaRepository<TV, Long> {
    List<TV> findByBrand(String brand);
    List<TV> findByIsSmart(Boolean isSmart);
}