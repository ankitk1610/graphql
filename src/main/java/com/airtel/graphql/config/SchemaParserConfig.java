package com.airtel.graphql.config;

import com.airtel.graphql.model.OfferResponse1;
import com.airtel.graphql.model.OfferResponse2;
import graphql.kickstart.tools.SchemaParserDictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemaParserConfig {

    @Bean
    public SchemaParserDictionary schemaParserDictionary() {
        return new SchemaParserDictionary()
                .add(OfferResponse1.class).add(OfferResponse2.class);
    }

}
