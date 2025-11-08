package homeworks.homework22.repository;

import homeworks.homework22.entity.Tv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvRepository extends JpaRepository<Tv, Long> {

    List<Tv> findByBrand(String brand);

    List<Tv> findByIsSmart(Boolean isSmart);
}