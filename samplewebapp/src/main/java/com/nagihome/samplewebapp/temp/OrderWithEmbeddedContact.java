package com.nagihome.samplewebapp.temp;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderWithEmbeddedContact {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    /*@AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "weekendname")),
            @AttributeOverride(name = "contact", column = @Column(name = "weekendcontact")),
            @AttributeOverride(name = "address", column = @Column(name = "weekendaddress"))
    }
    )*/
    private EmbeddedContact weekDayContact;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "holidayname")),
            @AttributeOverride(name = "phone", column = @Column(name = "holidayphone")),
            @AttributeOverride(name = "address", column = @Column(name = "holidayaddress"))
    })
    private EmbeddedContact holidayContact;

}
