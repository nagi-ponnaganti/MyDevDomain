package com.nagihome.samplewebapp.temp;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sequence_id_entity")
@Data
public class SequenceIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_entity")
    @SequenceGenerator(name = "seq_id_entity", sequenceName = "seq_id_entity_seq", allocationSize = 10, initialValue = 4)
    private long id;
    @Column(name = "field")
    private String field;

}
