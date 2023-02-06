package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser extends DefaultEntity {

    private String name;

    private String email;

    private String password;

    @ToString.Exclude
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "app_user_role",
            joinColumns = @JoinColumn(name = "app_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
