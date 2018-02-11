package com.nagihome.samplewebapp.temp;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customer")
@DynamicUpdate
@DynamicInsert
@Data
public class Customer {

    @Id
    @GenericGenerator(name="customergen", strategy = "increment")
    @GeneratedValue(generator = "customergen")
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @ElementCollection(targetClass = Address.class, fetch = FetchType.EAGER)
    @JoinTable(name = "Address", joinColumns = @JoinColumn(name = "Customer_ID"))
    private Set<Address> addresses;
}
