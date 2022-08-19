package com.airtel.graphql.resolver.bank.subscrition.publisher;

import com.airtel.graphql.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountPublisher {


    private final FluxProcessor<BankAccount, BankAccount> processor;
    private final FluxSink<BankAccount> sink;


    public BankAccountPublisher() {

        this.processor = DirectProcessor.<BankAccount>create().serialize();
        this.sink = processor.sink();

    }

    public Publisher<BankAccount> getBankAccountPubisher() {

        return processor.map(t -> {
            log.info("Publishing for bank Account {}", t);
            return t;
        });
    }

    public Publisher<BankAccount> getBankAccountPubisherFor(UUID id) {
        return processor.filter(t -> t.getId() == id).map(t -> {
            log.info("Publishing for individual bank Account {}", t);
            return t;
        });

    }

    public void publish(BankAccount account) {
        sink.next(account);

    }
}
