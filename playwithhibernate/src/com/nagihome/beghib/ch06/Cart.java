package com.nagihome.beghib.ch06;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CART_NAME")
    private String name;
    @Column(name = "CART_TOTAL")
    private Double total;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private Set<Item> itemSet = new HashSet<>();

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", itemSet=" + itemSet +
                '}';
    }
}
