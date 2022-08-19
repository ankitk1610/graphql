package com.airtel.graphql.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ScalarConfig {


    @Bean
    public GraphQLScalarType nonNegativeInt() {
        return ExtendedScalars.NonNegativeInt;
    }

    @Bean
    public GraphQLScalarType DateTime() {
        return ExtendedScalars.DateTime;
    }


    @Bean
    public GraphQLScalarType Date() {
        return ExtendedScalars.Date;
    }
}
