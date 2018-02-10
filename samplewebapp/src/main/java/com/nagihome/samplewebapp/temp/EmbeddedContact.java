package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class EmbeddedContact {
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String address;
}
