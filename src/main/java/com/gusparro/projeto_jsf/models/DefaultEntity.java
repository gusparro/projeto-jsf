package com.gusparro.projeto_jsf.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class DefaultEntity {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

}
