package com.nagihome.samplewebapp.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Column
    private int areaCode;
    @Column
    private int exchange;
    @Column
    private int number;

}
