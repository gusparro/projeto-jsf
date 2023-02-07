package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends DefaultEntity {

    private String name;

    private String description;

    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private List<AppUser> appUsers;

}
