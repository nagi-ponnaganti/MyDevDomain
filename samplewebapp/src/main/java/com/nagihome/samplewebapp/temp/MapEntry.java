package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class MapEntry {
    @Id
    private int key1;
    @Column
    private String value1;
}
