package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class Phone2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String phoneNum;
    @ManyToOne
    private Person2 person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Person2 getPerson() {
        return person;
    }

    public void setPerson(Person2 person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Phone2{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
