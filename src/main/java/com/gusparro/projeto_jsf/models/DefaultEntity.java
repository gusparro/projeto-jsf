package com.gusparro.projeto_jsf.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
public abstract class DefaultEntity {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @Temporal(TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    protected LocalDateTime createdAt;

    @Temporal(TIMESTAMP)
    @Column(name = "updated_at", insertable = false)
    protected LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void beforeUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultEntity that = (DefaultEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
