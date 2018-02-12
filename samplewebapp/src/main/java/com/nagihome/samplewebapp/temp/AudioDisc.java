package com.nagihome.samplewebapp.temp;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AudioDisc extends Disc {

    @Column
    private int trackCount;

    @Column
    private String artist;
}
