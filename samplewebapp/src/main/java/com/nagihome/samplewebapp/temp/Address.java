package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "Address")
@Data
public class Address {

    @Column
    private String address1;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zip;
    @Column
    private String parent;
}
