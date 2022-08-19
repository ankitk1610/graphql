package com.airtel.graphql.resolver.bank.query;

import com.airtel.graphql.model.OfferResponse1;
import com.airtel.graphql.model.OfferResponse2;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OfferQueryResolver implements GraphQLQueryResolver {

    public Object offers (String id) {

        if(id.equals("aa")) {
            return OfferResponse1.builder().description("des1").id(id).isPrimeUser(true).build();
        }
        return OfferResponse2.builder().validity("val").description("des").condition("condition").id(id).build();



    }

//    public OfferResponse1 offers(String id) {
//        return OfferResponse1.builder().description("des1").id(id).isPrimeUser(true).build();
//
//    }
}
