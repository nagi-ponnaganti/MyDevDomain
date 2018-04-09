package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String provider;

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

    @Override
    public String toString() {
        return "PhoneDetails{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                '}';
    }
}
