package com.nagihome.samplewebapp.entity;

import com.nagihome.samplewebapp.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="film_actor")
public class FilmActor {

    @Id
    @Column(name = "actor_id")
    private long actorId;
    @Column(name = "film_id")
    private long filmId;
    @Column(name = "last_update")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdate;

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
