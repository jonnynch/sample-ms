package com.example.demo;

import io.micrometer.observation.tck.TestObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import static io.micrometer.observation.tck.TestObservationRegistryAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableTestObservation
@Slf4j
@ActiveProfiles("local")
class ObservationFilterTests {
    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    TestObservationRegistry registry;

    @Test
    void testObservation() {
        // invoke service
        this.restTemplate.getForObject("http://localhost:" + port + "/api/book",
                String.class);
        assertThat(registry)
                .hasObservationWithNameEqualTo("http.server.requests")
                .that()
                .hasBeenStarted()
                .hasBeenStopped();
    }
}