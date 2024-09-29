package com.shadowhokageforge.eventservice.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String detail;
    @Column(name = "start_date_time")
    private OffsetDateTime start;
    @Column(name = "end_date_time")
    private OffsetDateTime end;
    private boolean isOnline;
    private String eventLink;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Location location;
    private OffsetDateTime createdOn;
    private OffsetDateTime updatedOn;
    private UUID createdBy;
    private UUID updatedBy;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private List<Tag> tags;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private List<Attendee> attendees;

    public Event() {
        tags = new ArrayList<>();
        attendees = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public Event setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Event setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public OffsetDateTime getStart() {
        return start;
    }

    public Event setStart(OffsetDateTime start) {
        this.start = start;
        return this;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public Event setEnd(OffsetDateTime end) {
        this.end = end;
        return this;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public Event setOnline(boolean online) {
        isOnline = online;
        return this;
    }

    public String getEventLink() {
        return eventLink;
    }

    public Event setEventLink(String eventLink) {
        this.eventLink = eventLink;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Event setLocation(Location location) {
        this.location = location;
        return this;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public Event setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public OffsetDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Event setUpdatedOn(OffsetDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public Event setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public Event setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Event setTags(List<Tag> tags) {
        this.tags = new ArrayList<>(tags);;
        return this;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public Event setAttendees(List<Attendee> attendees) {
        this.attendees = new ArrayList<>(attendees);
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", from=").append(start);
        sb.append(", to=").append(end);
        sb.append(", isOnline=").append(isOnline);
        sb.append(", eventLink='").append(eventLink).append('\'');
        sb.append(", location=").append(location);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", tags=").append(tags);
        sb.append(", attendees=").append(attendees);
        sb.append('}');
        return sb.toString();
    }
}
