package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class RelatedContact {

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String address;

}
