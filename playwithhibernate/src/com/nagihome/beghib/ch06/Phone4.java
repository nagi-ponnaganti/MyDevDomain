package com.nagihome.beghib.ch06;

import javax.persistence.*;

@Entity
public class Phone4 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String phoneNum;
    @OneToOne(mappedBy = "phone4", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PhoneDetails4 phoneDetails4;

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

    public PhoneDetails4 getPhoneDetails4() {
        return phoneDetails4;
    }

    public void setPhoneDetails4(PhoneDetails4 phoneDetails4) {
        this.phoneDetails4 = phoneDetails4;
    }

    @Override
    public String toString() {
        return "Phone4{" +
                "id=" + id +
                ", phoneNum='" + phoneNum + '\'' +
                ", phoneDetails4=" + phoneDetails4 +
                '}';
    }
}
