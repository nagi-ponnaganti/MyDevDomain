package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="table_id_entity")
@Data
public class TableIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
    @TableGenerator(name = "table_generator", table = "id_generator")
    private long id;
    @Column(name = "value")
    private String value;

    public TableIdEntity() {
    }
}
