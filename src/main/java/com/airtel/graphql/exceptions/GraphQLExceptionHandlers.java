package com.airtel.graphql.exceptions;

import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;


//Error Handler Approach #1
@Component
public class GraphQLExceptionHandlers {


    @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class})
    public ThrowableGraphQLError handle(Exception e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler({RuntimeException.class})
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e, "Runtime Exception");
    }



}
