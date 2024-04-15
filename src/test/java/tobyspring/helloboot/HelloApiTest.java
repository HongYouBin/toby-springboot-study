package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.*;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                testRestTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");

        // status 200,
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello Spring
        assertThat(response.getBody()).isEqualTo("Hello Spring");
    }

    @Test
    void failTelloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate testRestTemplate = new TestRestTemplate();

        ResponseEntity<String> response =
                testRestTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class);

        // status 200,
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
