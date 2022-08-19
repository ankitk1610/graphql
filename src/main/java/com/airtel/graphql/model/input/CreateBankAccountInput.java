package com.airtel.graphql.model.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateBankAccountInput {

    @NotBlank
    private String firstName;
    private  int age;
}
