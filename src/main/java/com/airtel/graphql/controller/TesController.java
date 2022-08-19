//package com.airtel.graphql.controller;
//
//import com.airtel.graphql.model.BankAccount;
//import com.airtel.graphql.resolver.bank.query.BankAccountQueryResolver;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class TesController {
//
//    @Autowired
//    BankAccountQueryResolver bankAccountQueryResolver;
//
//    @GetMapping("/test")
//    public String test() {
//        BankAccount bankAccount = bankAccountQueryResolver.test();
//        log.info("account: {}", bankAccount);
//
//
//        return "success";
//    }
//
//}
