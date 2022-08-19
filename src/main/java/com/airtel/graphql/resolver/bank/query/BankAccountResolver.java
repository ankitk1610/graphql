package com.airtel.graphql.resolver.bank.query;

import com.airtel.graphql.context.dataloader.DataLoaderRegistryFactory;
import com.airtel.graphql.model.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

//    public BigDecimal getBalance(BankAccount account) throws InterruptedException {
//
//
//        Thread.sleep(500);
//        log.info("getting balance for {}",account.getId());
//
//        return BigDecimal.ONE;
//
//    }


    public CompletableFuture<BigDecimal> getBalance(BankAccount account, DataFetchingEnvironment environment) {

//        log.info("Getting balance for {}", account.getId());

        DataLoader<UUID, BigDecimal> dataLoader =   environment.getDataLoader(DataLoaderRegistryFactory.BALANCE_DATA_LOADER);
        return dataLoader.load(account.getId(),account);


    }

}
