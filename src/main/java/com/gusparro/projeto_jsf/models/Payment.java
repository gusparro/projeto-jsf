package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment extends DefaultEntity {

    private String cardNumber;

    private String barcode;

    @Enumerated(STRING)
    private PaymentStatus status;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

}
