package com.airtel.graphql.resolver.bank.mutation;

import graphql.kickstart.servlet.DefaultGraphQLServlet;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
        log.info("Upload file");
        DefaultGraphQLServletContext servletContext = environment.getContext();

        List<Part> partList = servletContext.getFileParts();

        partList.forEach(t -> {

                    log.info("Uploading file {}, size {}", t.getSubmittedFileName(), t.getSize());

                }
        );
        return UUID.randomUUID();
    }

}
