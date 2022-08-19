package com.airtel.graphql.resolver.bank.mutation;

import com.airtel.graphql.config.ClockConfig;
import com.airtel.graphql.model.BankAccount;
import com.airtel.graphql.model.Currency;
import com.airtel.graphql.model.input.CreateBankAccountInput;
import com.airtel.graphql.resolver.bank.subscrition.publisher.BankAccountPublisher;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component

@Validated
@RequiredArgsConstructor
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;


    private final BankAccountPublisher publisher;

//    public BankAccount createBankAccount(CreateBankAccountInput input) {
//
//        log.info("Creating bank account for {}" , input);
//        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.INR).build();
//
//    }

    public BankAccount createBankAccount(@Valid CreateBankAccountInput input, DataFetchingEnvironment environment) {


        log.info("Creating bank account for {}" , input);
        Set<String> requestedFields = environment.getSelectionSet().getFields().stream().map(SelectedField::getName).collect(Collectors.toUnmodifiableSet());

        log.info("requested fields : {}", requestedFields);
        var account =  BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.INR)
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();

        publisher.publish(account);
        return account;

    }

}
