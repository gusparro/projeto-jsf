package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client extends DefaultEntity {

    private String name;

    private String email;

    private String cpf;

    @Enumerated(STRING)
    private Gender gender;

    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

}
