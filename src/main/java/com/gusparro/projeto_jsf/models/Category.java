package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends DefaultEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @ToString.Exclude
    @OneToMany(mappedBy = "parentCategory")
    private List<Category> categories;

    @ToString.Exclude
    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

}
