package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends DefaultEntity {

    private String name;

    private String description;

    private BigDecimal price;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToOne(mappedBy = "product", cascade = ALL)
    private Stock stock;

}
