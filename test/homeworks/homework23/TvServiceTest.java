package homeworks.homework23;

import homeworks.homework22.entity.Tv;
import homeworks.homework22.repository.TvRepository;
import homeworks.homework22.service.TvService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TvServiceTest {

    @Test
    void findAll_returnsList() {
        var repo = mock(TvRepository.class);
        var service = new TvService(repo);

        when(repo.findAll()).thenReturn(List.of(new Tv(), new Tv()));

        var result = service.findAll();

        assertThat(result).hasSize(2);
        verify(repo, times(1)).findAll();
    }

    @Test
    void save_persistsEntity() {
        var repo = mock(TvRepository.class);
        var service = new TvService(repo);

        var tv = new Tv(null, "LG", "C1", 65, new BigDecimal("129990"), true, null);
        when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        var saved = service.save(tv);

        var captor = ArgumentCaptor.forClass(Tv.class);
        verify(repo).save(captor.capture());
        assertThat(captor.getValue().getBrand()).isEqualTo("LG");
        assertThat(saved.getModel()).isEqualTo("C1");
    }

    @Test
    void findById_found() {
        var repo = mock(TvRepository.class);
        var service = new TvService(repo);

        var tv = new Tv(); tv.setId(1L);
        when(repo.findById(1L)).thenReturn(Optional.of(tv));

        var found = service.findById(1L);

        assertThat(found).isPresent();
    }
}
