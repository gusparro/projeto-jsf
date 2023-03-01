package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 8, max = 128)
    private String name;

    @Email
    @NotBlank
    @Size(min = 8, max = 255)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    @ToString.Exclude
    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "appuser_role",
            joinColumns = @JoinColumn(name = "appuser_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
