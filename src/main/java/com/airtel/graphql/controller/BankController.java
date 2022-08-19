//package com.airtel.graphql.controller;
//
//import com.airtel.graphql.model.OfferResponse1;
//import com.airtel.graphql.resolver.bank.query.BankAccountQueryResolver;
//import com.airtel.graphql.resolver.bank.query.OfferQueryResolver;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//public class BankController {
//
////    @Autowired
////    OfferQueryResolver resolver;
//
//    @Autowired
//    ObjectMapper mapper;
//
//
//    @GetMapping("/test")
//    public String test() throws JsonProcessingException {
//
////        Object ans =  resolver.offers("aaa");
////        log.info(mapper.writeValueAsString(ans));
//        return "success";
//    }
//
//}
