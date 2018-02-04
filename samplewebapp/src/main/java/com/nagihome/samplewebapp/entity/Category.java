package com.nagihome.samplewebapp.entity;

import com.nagihome.samplewebapp.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    private long categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdate;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
