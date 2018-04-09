package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class PhoneDetails4 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String provider;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Phone4 phone4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Phone4 getPhone4() {
        return phone4;
    }

    public void setPhone4(Phone4 phone4) {
        this.phone4 = phone4;
    }

    @Override
    public String toString() {
        return "PhoneDetails4{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                '}';
    }
}
