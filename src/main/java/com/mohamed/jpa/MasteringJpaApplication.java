package com.mohamed.jpa;

import com.github.javafaker.Faker;
import com.mohamed.jpa.models.Author;
import com.mohamed.jpa.models.Video;
import com.mohamed.jpa.repositories.AuthorRepository;
import com.mohamed.jpa.repositories.VideoRepository;
import com.mohamed.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootApplication
public class MasteringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasteringJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            VideoRepository videoRepository){
        return args -> {
            /*for (int i = 0; i < 50; i++) {
                Faker faker = new Faker();
            var author= Author.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .age(faker.number().numberBetween(17,75))
                    .email(faker.name().username()+"aaa@gmail.com")
                    .createdAt(LocalDateTime.now())
                    .build();

            authorRepository.save(author);
            }
            */




            /*var author= Author.builder()
                    .id(50)
                    .firstName("Ibrahim")
                    .lastName("Mohamed")
                    .age(23)
                    .email("aaa2@gmail.com")
                    .createdAt(LocalDateTime.now())
                    .lastModifiedAt(LocalDateTime.now())
                    .build();

            authorRepository.save(author);

             */

          /*  var video= Video.builder()
                    .length(34)
                    .url("dfsfsgs.com")
                    .size(23)
                    .build();

            videoRepository.save(video);

           */

            //authorRepository.updateAuthor(24,4);

            // authorRepository.findByNamedQuery(40).forEach(System.out::println);
            //authorRepository.updateNamedQuery(18);


            Specification<Author> spec=Specification
                    .where(AuthorSpecification.hasAge(18))
                    .and(AuthorSpecification.firstNameLike("Marlin"));
            authorRepository.findAll(spec).forEach(System.out::println);
        };
    }

}
