package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends DefaultEntity {

    @Column(unique = true)
    private String name;

    private String description;

}
