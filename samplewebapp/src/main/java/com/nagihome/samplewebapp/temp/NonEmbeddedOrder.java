package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class NonEmbeddedOrder {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String weekdayRecipientName;
    @Column
    private String weekdayPhoneNumber;
    @Column
    private String weekdayAddress;
    @Column
    private String holidayRecipientName;
    @Column
    private String holidayPhoneNumber;
    @Column
    private String holidayAddress;

}
