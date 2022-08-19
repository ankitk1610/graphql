package com.airtel.graphql;

//import com.airtel.graphql.model.Author;
//import com.airtel.graphql.model.Book;
//import com.airtel.graphql.repository.AuthorRepository;
//import com.airtel.graphql.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);


    }
//
//    @Bean
//    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
//        return args -> {
//            Author ankit = authorRepository.save(new Author(null, "Ankit"));
//            Author kumar = authorRepository.save(new Author(null, "Kumar"));
//            bookRepository.saveAll(List.of(
//                    new Book(null, "Reactive Java", "Self", ankit),
//                    new Book(null, "Head First Java", "Self", kumar))
//            );
//
//        };
//    }


    //
//    @Bean
//    ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
//        return args -> {
//            Author ankit = authorRepository.save(new Author(null, "Ankit"));
//            Author kumar = authorRepository.save(new Author(null, "Kumar"));
//            bookRepository.saveAll(List.of(
//                    new Book(null, "Reactive Java", "Self", ankit),
//                    new Book(null, "Head First Java", "Self", kumar))
//            );
//
//        };
//    }

}
