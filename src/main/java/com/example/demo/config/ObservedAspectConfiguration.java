package com.example.demo.config;

import com.example.demo.config.observation.SimpleLoggingHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.observation.ServerRequestObservationContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Configuration
@Slf4j
public class ObservedAspectConfiguration {

    @Bean
    ObservationRegistryCustomizer<ObservationRegistry> skipActuatorEndpointsFromObservation() {
        PathMatcher pathMatcher = new AntPathMatcher("/");
        return (registry) -> registry.observationConfig().observationPredicate((name, context) -> {
            if (context instanceof ServerRequestObservationContext observationContext) {
                return !pathMatcher.match("/actuator/**", observationContext.getCarrier().getRequestURI());
            } else {
                return true;
            }
        });
    }

    @Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        //just for debugging
        observationRegistry.observationConfig().observationHandler(new SimpleLoggingHandler());
        return new ObservedAspect(observationRegistry);
    }
}