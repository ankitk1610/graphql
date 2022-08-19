package com.airtel.graphql.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
@ToString
public class BankAccount {

    UUID id;
    Client client;
    Currency currency;
    ZonedDateTime createdAt;
    LocalDate createdOn;
    BigDecimal balance;

}
