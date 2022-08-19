package com.airtel.graphql.service;

import com.airtel.graphql.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class BalanceService {


    public Map<UUID,BigDecimal> getBalance(Set<UUID> accountIds, String userId) {

        log.info("Getting balance for accountIds {}, userId {} ", accountIds, userId);
        return Map.of();
    }

    public Map<UUID,BigDecimal> getBalanceKeyContext(Map<UUID, BankAccount> bankAccounts, String userId) {

        log.info("Getting balance for accountIds {}, userId {} ", bankAccounts, userId);
        return Map.of();
    }


}
