package com.nagihome.samplewebapp.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Phone phone;

}
