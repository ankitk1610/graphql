package com.airtel.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Client {

    private String firstName;
    private List<String> middleName;
    private String lastName;
    private UUID id;
}
