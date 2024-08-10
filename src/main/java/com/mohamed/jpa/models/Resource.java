package com.mohamed.jpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
public class Resource  {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int  size;
    private String url;

    @OneToOne
    private Lecture lecture;
}
