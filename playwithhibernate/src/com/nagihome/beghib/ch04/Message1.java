package com.nagihome.beghib.ch04;

import javax.persistence.*;

@Entity
public class Message1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Email1 email1;

    @Column
    private String text;

    public Message1() {
    }

    public Message1(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Email1 getEmail1() {
        return email1;
    }

    public void setEmail1(Email1 email1) {
        this.email1 = email1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message1{" +
                "id=" + id +
                ", email1=" + email1 +
                ", text='" + text + '\'' +
                '}';
    }
}
