package com.nagihome.beghib.ch04;

import javax.persistence.*;

@Entity
public class Email1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Message1 message1;

    @Column
    private String text;

    public Email1() {
    }

    public Email1(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message1 getMessage1() {
        return message1;
    }

    public void setMessage1(Message1 message1) {
        this.message1 = message1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
