package com.airtel.graphql.repository;

import com.airtel.graphql.model.BankAccount;
import com.airtel.graphql.model.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component

@Slf4j
public class BankAccountRepository {

    private final List<BankAccount> bankAccountList = List.of(

            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.USD).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.INR).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.CNF).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.EUR).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.USD).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.INR).build(),
            BankAccount.builder().createdOn(LocalDate.now().now()).id(UUID.randomUUID()).currency(Currency.EUR).build()


    ).stream().sorted(Comparator.comparing(BankAccount::getId)).collect(Collectors.toUnmodifiableList());

    public List<BankAccount> getBankAccounts() {


log.info( "Bank Accounts {}",bankAccountList);
        return bankAccountList;
    }

    public List<BankAccount> getBankAccountsAfter(UUID id) {

        return bankAccountList.stream().dropWhile(t -> t.getId().compareTo(id) != 1).collect(Collectors.toUnmodifiableList());
    }

}
