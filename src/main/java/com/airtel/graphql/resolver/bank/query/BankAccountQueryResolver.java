package com.airtel.graphql.resolver.bank.query;

import com.airtel.graphql.connection.CursorUtil;
import com.airtel.graphql.model.BankAccount;
import com.airtel.graphql.model.Currency;
import com.airtel.graphql.repository.BankAccountRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountQueryResolver implements GraphQLQueryResolver {


    private final BankAccountRepository bankAccountRepository;
    private final CursorUtil cursorUtil;

//    public BankAccount bankAccount(UUID id) {
//
//        log.info("Getting bank account for id {}", id);
//
//
////        return BankAccount.builder().currency(Currency.INR).client(new Client("Ankit",null, "Kumar", id)).id(id).build();
//        return BankAccount.builder().currency(Currency.INR).id(id).build();
//    }

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {

//        CustomGraphQLContext context =  environment.getContext();
//        log.info("Getting bank account for id {}, userid {}", id, context.getUserId());


//        return BankAccount.builder().currency(Currency.INR).client(new Client("Ankit",null, "Kumar", id)).id(id).build();
        return BankAccount.builder().currency(Currency.INR).createdOn(LocalDate.now().now()).id(id).build();
    }




    public Connection<BankAccount> bankAccounts(int first, @Nullable String after) {

        List<Edge<BankAccount>> edges = getBankAccounts(after).stream().map(t ->
                new DefaultEdge<>(t, cursorUtil.createCursorFromUUID(t.getId()))
        ).limit(first).collect(Collectors.toUnmodifiableList());

        var firstCursor = cursorUtil.getFirstCursorFrom(edges);
        var lastCursor = cursorUtil.getLastCursorFrom(edges);

        DefaultPageInfo pageInfo = new DefaultPageInfo(firstCursor, lastCursor, after != null, edges.size() >= first);

        return new DefaultConnection<>(edges, pageInfo);

    }

    private List<BankAccount> getBankAccounts(String after){
        if (after == null) {
           return  bankAccountRepository.getBankAccounts();
        }
        return bankAccountRepository.getBankAccountsAfter(cursorUtil.getUUIDfromCursor(after));

    }

    public  BankAccount test() {
        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.INR).build();
    }

}
