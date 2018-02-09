package com.nagihome.samplewebapp.temp;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@Data
@DynamicInsert
@DynamicUpdate
public class DynamicSqlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String field1;
    @Column
    private String field2;
}
