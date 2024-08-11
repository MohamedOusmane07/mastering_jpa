package com.mohamed.jpa.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a LEFT JOIN FETCH a.courses where a.age >=:age"
        ),
        @NamedQuery(
                name = "Author.updateNamedQuery",
                query = "update Author a set a.age= :age"
        )
})
public class Author extends BaseEntity {



    @Column(
            name = "f-name",
            length = 35
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
