package homeworks.homework23;

import homeworks.homework22.TvApplication;
import homeworks.homework22.entity.Tv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TvApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("homework23")
@Testcontainers
class TvApiIntegrationTest {

    @Container
    static PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", pg::getJdbcUrl);
        r.add("spring.datasource.username", pg::getUsername);
        r.add("spring.datasource.password", pg::getPassword);
    }

    @LocalServerPort int port;
    @Autowired TestRestTemplate rest;

    String url(String p) { return "http://localhost:" + port + p; }

    @Test
    void fullFlow_crudOK() {
        // CREATE
        var body = new Tv(null, "Philips", "5500", 32, new BigDecimal("19990"), false, null);
        var respCreate = rest.postForEntity(url("/api/tvs"), body, Tv.class);
        assertThat(respCreate.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Long id = respCreate.getBody().getId();

        // READ
        var getOne = rest.getForEntity(url("/api/tvs/" + id), Tv.class);
        assertThat(getOne.getBody().getBrand()).isEqualTo("Philips");

        // UPDATE
        body.setPrice(new BigDecimal("20990"));
        var request = new HttpEntity<>(body);
        var updateResp = rest.exchange(URI.create(url("/api/tvs/" + id)), HttpMethod.PUT, request, Tv.class);
        assertThat(updateResp.getStatusCode()).isEqualTo(HttpStatus.OK);

        // LIST
        var list = rest.getForEntity(url("/api/tvs"), Tv[].class);
        assertThat(list.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(list.getBody().length).isGreaterThanOrEqualTo(1);

        // DELETE
        rest.delete(url("/api/tvs/" + id));
        var afterDelete = rest.getForEntity(url("/api/tvs/" + id), Tv.class);
        assertThat(afterDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
