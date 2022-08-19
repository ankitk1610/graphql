package com.airtel.graphql.context;

import com.airtel.graphql.context.dataloader.DataLoaderRegistryFactory;
import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {

    private  final DataLoaderRegistryFactory factory ;

    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        // HTTP, hook for graphQL context
        var userId = httpServletRequest.getHeader("user_id");

        var context = DefaultGraphQLServletContext.createServletContext().
                with(httpServletRequest).
                with(httpServletResponse).with(factory.create(userId)).build();
        return new CustomGraphQLContext(userId, context);
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
        // Socket
//        throw new IllegalStateException("Unsupported");

        return DefaultGraphQLWebSocketContext.createWebSocketContext().with(session).with(handshakeRequest).build();
    }

    @Override
    public GraphQLContext build() {
        throw new IllegalStateException("Unsupported");
    }
}
