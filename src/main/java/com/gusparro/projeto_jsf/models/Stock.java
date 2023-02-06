package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock extends DefaultEntity {

    private Long productId;

    private Long amount;

}
