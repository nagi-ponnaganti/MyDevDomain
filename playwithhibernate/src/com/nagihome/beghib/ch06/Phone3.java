package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class Phone3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String phoneNum;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private PhoneDetails phoneDetails;

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

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public void setPhoneDetails(PhoneDetails phoneDetails) {
        this.phoneDetails = phoneDetails;
    }

    @Override
    public String toString() {
        return "Phone3{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                ", phoneDetails=" + phoneDetails +
                '}';
    }
}
