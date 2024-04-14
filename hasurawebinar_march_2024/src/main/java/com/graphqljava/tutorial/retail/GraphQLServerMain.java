package com.graphqljava.tutorial.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@SpringBootApplication()
@EnableConfigurationProperties
public class GraphQLServerMain {
    public static void main(final String[] args) {
        SpringApplication.run(GraphQLServerMain.class, args);
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> builder.scalar(LocalDateTimeScalar.INSTANCE);
    }
}
