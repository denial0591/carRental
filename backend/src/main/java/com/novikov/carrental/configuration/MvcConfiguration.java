package com.novikov.carrental.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class MvcConfiguration {

    @Bean
    public ProjectionFactory projectionFactory() {
        return new SpelAwareProxyProjectionFactory();
    }

    @Bean
    public ObjectMapper ObjectMapper(Jackson2ObjectMapperBuilder builder) {
        return builder.build()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }
}
