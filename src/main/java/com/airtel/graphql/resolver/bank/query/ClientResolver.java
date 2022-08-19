package com.airtel.graphql.resolver.bank.query;

import com.airtel.graphql.model.BankAccount;
import com.airtel.graphql.model.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {


    // Approach 1: Simplest
//    public Client client(BankAccount bankAccount) {
//        log.info("Getting client for bank account {}", bankAccount.getId());
////        throw new RuntimeException("Some Exception Occurred");
//        return Client.builder().id(UUID.randomUUID()).lastName("Kumar").firstName("Ankit").build();
//    }

//    Approach 2: Using DataFetcher : to send "partial" result
//public DataFetcherResult<Client> client(BankAccount bankAccount) {
//    log.info("Getting client for bank account {}", bankAccount.getId());
//    return DataFetcherResult.<Client>newResult().
//            data(Client.builder().id(UUID.randomUUID()).lastName("Kumar").firstName("Ankit").build()).
//            error(new GenericGraphQLError("error in getting sublicent")).build();
//
//}


    // Approach 3: Async response
    private final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Async Client data");

        return CompletableFuture.supplyAsync(() -> {
            return Client.builder().id(UUID.randomUUID()).lastName("Kumar").firstName("Ankit").build();


        });
    }


}
