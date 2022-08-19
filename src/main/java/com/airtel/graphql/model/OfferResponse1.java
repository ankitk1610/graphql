package com.airtel.graphql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfferResponse1 {

    private String id;

    private String description;
    private boolean isPrimeUser;

}
