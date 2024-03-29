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

    @Column(name = "card_number")
    private String cardNumber;

    private String barcode;

    @Enumerated(STRING)
    private PaymentStatus status;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Order order;

}
