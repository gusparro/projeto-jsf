package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice extends DefaultEntity {

    @Lob
    private byte[] xml;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

}
