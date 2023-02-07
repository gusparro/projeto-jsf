package com.gusparro.projeto_jsf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice extends DefaultEntity {

    private String xml;

    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

}
