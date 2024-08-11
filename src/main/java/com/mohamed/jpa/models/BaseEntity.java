package com.mohamed.jpa.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(updatable = false)
    private LocalDateTime createdAt;

    @JoinColumn(insertable = false)
    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;
}
