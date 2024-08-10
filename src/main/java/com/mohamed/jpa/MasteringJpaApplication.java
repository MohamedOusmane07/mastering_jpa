package com.mohamed.jpa;

import com.mohamed.jpa.models.Author;
import com.mohamed.jpa.models.Video;
import com.mohamed.jpa.repositories.AuthorRepository;
import com.mohamed.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
//            var author= Author.builder()
//                    .firstName("Mohamed")
//                    .lastName("Hamed")
//                    .age(23)
//                    .email("aaa@gmail.com")
//                    .createdAt(LocalDateTime.now())
//                    .build();
//
//            authorRepository.save(author);

            var video= Video.builder()
                    .length(34)
                    .url("dfsfsgs.com")
                    .size(23)
                    .build();

            videoRepository.save(video);
        };
    }

}
