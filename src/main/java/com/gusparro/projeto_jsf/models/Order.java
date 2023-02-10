package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends DefaultEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    private BigDecimal total;

    @Enumerated(STRING)
    private OrderStatus status;

    @OneToOne(mappedBy = "order", orphanRemoval = true)
    private Invoice invoice;

    @OneToOne(mappedBy = "order", orphanRemoval = true)
    private Payment payment;

    @ToString.Exclude
    @OneToMany(mappedBy = "order", cascade = ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public void calculateTotalAmount() {
        if (orderItems != null) {
            total = orderItems.stream()
                    .map(item -> item.getProductPrice().multiply(new BigDecimal(item.getAmount())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }
    
    @Override
    public void beforePersist() {
        super.beforePersist();
        calculateTotalAmount();
    }

    @Override
    public void beforeUpdate() {
        super.beforeUpdate();
        calculateTotalAmount();
    }

}
