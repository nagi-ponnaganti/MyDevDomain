package com.nagihome.beghib.ch06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CPKBook {
    @Id
    private ISBN id;
    @Column
    private String name;

    public CPKBook() {
    }

    public ISBN getId() {
        return id;
    }

    public void setId(ISBN id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }
}