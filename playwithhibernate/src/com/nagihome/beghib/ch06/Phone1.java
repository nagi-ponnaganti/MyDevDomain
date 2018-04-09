package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class Phone1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String phoneNum;

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

    @Override
    public String toString() {
        return "Phone1{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
