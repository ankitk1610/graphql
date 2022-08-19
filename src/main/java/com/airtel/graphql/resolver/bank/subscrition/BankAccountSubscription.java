package com.airtel.graphql.resolver.bank.subscrition;


import com.airtel.graphql.model.BankAccount;
import com.airtel.graphql.resolver.bank.subscrition.publisher.BankAccountPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BankAccountSubscription implements GraphQLSubscriptionResolver {


    private final BankAccountPublisher publisher;

    public Publisher<BankAccount> bankAccounts() {

        return publisher.getBankAccountPubisher();

    }


    public Publisher<BankAccount> bankAccount(UUID id) {
        return publisher.getBankAccountPubisherFor(id);

    }


}
