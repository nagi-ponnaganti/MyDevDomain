package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderWithRelatedContact {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private RelatedContact weekdayContact;
    @ManyToOne(cascade = CascadeType.ALL)
    private RelatedContact holidayContact;

}
