package com.airtel.graphql;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = TestApplication.class)
public class BankAccountTest {


    private static final String  REQUEST = "request/%s";
    private static final String  RESPONSE = "response/%s";
    @Autowired
    GraphQLTestTemplate template;



    @Test
    void test1() throws IOException {
        var testName = "bank_account.graphql";
        GraphQLResponse response = template.postForResource(format(REQUEST, testName));
        String expected = read(format(RESPONSE, testName));
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());


//        Assertions.assertEquals(response.getRawResponse().getBody(), expected);


    }

    private String read(String location) throws IOException {

       return  IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);

    }
}
