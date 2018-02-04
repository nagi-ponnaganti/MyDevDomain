package com.nagihome.samplewebapp.entity;

import com.nagihome.samplewebapp.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "actor_id")
    private long actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdate;

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
