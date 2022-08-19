package com.airtel.graphql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferResponse2 {


    private String id;

    private String description;
    private String validity;
    private String condition;
}
