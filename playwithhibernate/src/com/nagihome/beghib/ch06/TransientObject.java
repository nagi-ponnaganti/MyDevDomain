package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class TransientObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String impField;
    @Transient
    private String nonImpField;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImpField() {
        return impField;
    }

    public void setImpField(String impField) {
        this.impField = impField;
    }

    public String getNonImpField() {
        return nonImpField;
    }

    public void setNonImpField(String nonImpField) {
        this.nonImpField = nonImpField;
    }
}
