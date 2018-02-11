package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "NestedOrder")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    @Column
    private Contact weekdayContact;
    @Embedded
    @Column
    private Contact holidayContact;

}
