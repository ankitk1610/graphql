package com.airtel.graphql.context.dataloader;

import com.airtel.graphql.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    private final BalanceService balanceService;
    public static final String BALANCE_DATA_LOADER = "BALANCE_DATA_LOADER";

    private static final Executor balanceThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public DataLoaderRegistry create(String userId) {
//       this resource will not be shared with other requests
        var registry = new DataLoaderRegistry();

//        registry.register(BALANCE_DATA_LOADER, createBalanceDataLoader(userId));
        registry.register(BALANCE_DATA_LOADER, createBalanceDataLoaderWithrKeyContext(userId));
        return registry;
    }

    private DataLoader<UUID, BigDecimal> createBalanceDataLoader(String userId) {
//        to maintain mapping of balance and accountId in response
        return DataLoader.newMappedDataLoader((Set<UUID> accountIds) ->
                CompletableFuture.supplyAsync(() -> balanceService.getBalance(accountIds, userId)
                        , balanceThreadPool));
    }



    private DataLoader<UUID, BigDecimal> createBalanceDataLoaderWithrKeyContext(String userId) {
//        to maintain mapping of balance and accountId in response
        return DataLoader.newMappedDataLoader((accountIds,environment) ->
                CompletableFuture.supplyAsync(() -> balanceService.getBalanceKeyContext((Map)environment.getKeyContexts(), userId)
                        , balanceThreadPool));
    }

}
