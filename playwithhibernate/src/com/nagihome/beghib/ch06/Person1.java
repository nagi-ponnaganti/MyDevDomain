package com.nagihome.beghib.ch06;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone1> phones = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone1> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone1> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                '}';
    }
}
