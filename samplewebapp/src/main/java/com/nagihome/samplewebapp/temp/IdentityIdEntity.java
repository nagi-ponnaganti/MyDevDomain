package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="identity_id_entity")
@Data
public class IdentityIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "value")
    private String value;

}
