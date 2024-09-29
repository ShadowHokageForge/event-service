package com.shadowhokageforge.eventservice.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "event_location_map")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String latitude;
    private String longitude;
    private String name;
    private String address;
    private String street;
    private String locality;
    private String city;
    private String state;
    private String country;
    private OffsetDateTime createdOn;
    private OffsetDateTime updatedOn;
    private UUID createdBy;
    private UUID updatedBy;

    public UUID getId() {
        return id;
    }

    public Location setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public Location setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public Location setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Location setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public Location setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Location setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Location setCountry(String country) {
        this.country = country;
        return this;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public Location setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public OffsetDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Location setUpdatedOn(OffsetDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public Location setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public Location setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("id=").append(id);
        sb.append(", latitude='").append(latitude).append('\'');
        sb.append(", longitude='").append(longitude).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", locality='").append(locality).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append('}');
        return sb.toString();
    }
}
