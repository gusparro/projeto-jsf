package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock extends DefaultEntity {

    private Long amount;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private Product product;

}
