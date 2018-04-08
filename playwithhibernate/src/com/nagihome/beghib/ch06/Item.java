package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
    @Column(name = "ITEM_NAME")
    private String name;
    @Column(name = "ITEM_TOTAL")
    private Double total;
    @Column(name = "ITEM_QUANTITY")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", quantity=" + quantity +
                '}';
    }
}
