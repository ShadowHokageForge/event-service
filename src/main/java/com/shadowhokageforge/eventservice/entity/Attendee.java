package com.shadowhokageforge.eventservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "event_attendee_map")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID evenId;
    private UUID userId;
    private boolean isHost;

    public UUID getId() {
        return id;
    }

    public Attendee setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getEvenId() {
        return evenId;
    }

    public Attendee setEvenId(UUID evenId) {
        this.evenId = evenId;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public Attendee setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public boolean isHost() {
        return isHost;
    }

    public Attendee setHost(boolean host) {
        isHost = host;
        return this;
    }
}
