package com.nagihome.samplewebapp.temp;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class VideoDisc extends Disc {

    @Column
    private String director;
    @Column
    private String language;

}
