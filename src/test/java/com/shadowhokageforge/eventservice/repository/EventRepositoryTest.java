package com.shadowhokageforge.eventservice.repository;

import com.shadowhokageforge.eventservice.entity.Event;
import com.shadowhokageforge.eventservice.entity.Location;
import com.shadowhokageforge.eventservice.entity.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.OffsetDateTime;
import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testSaveEvents() {
        Event event = new Event()
                .setName("Intro to Java")
                .setDetail("Introduction about Java concepts")
                .setStart(OffsetDateTime.now())
                .setEnd(OffsetDateTime.now().plusHours(2))
                .setOnline(Boolean.TRUE)
                .setEventLink("http://meet.google.com/abc-defg-hij")
                .setLocation(new Location()
                        .setLatitude("-6.2295695")
                        .setLongitude("106.747117")
                        .setName("Jakarta Tech Park")
                        .setAddress("Jakarta Tech Park")
                        .setStreet("Jakarta Tech Park")
                        .setLocality("Jakarta Tech Park")
                        .setCity("Jakarta")
                        .setState("Jakarta")
                        .setCountry("Indonesia")
                        .setCreatedOn(OffsetDateTime.now())
                        .setCreatedBy(UUID.randomUUID())
                )
                .setCreatedOn(OffsetDateTime.now())
                .setCreatedBy(UUID.randomUUID())
                .setTags(List.of(new Tag().setName("Java")));

        Event result = eventRepository.save(event);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(event, result);
    }

    @Test
    public void testGetEventsById() {
        Event event = new Event()
                .setName("Intro to Java")
                .setDetail("Introduction about Java concepts")
                .setStart(OffsetDateTime.now())
                .setEnd(OffsetDateTime.now().plusHours(2))
                .setOnline(Boolean.TRUE)
                .setEventLink("http://meet.google.com/abc-defg-hij")
                .setLocation(new Location()
                        .setLatitude("-6.2295695")
                        .setLongitude("106.747117")
                        .setName("Jakarta Tech Park")
                        .setAddress("Jakarta Tech Park")
                        .setStreet("Jakarta Tech Park")
                        .setLocality("Jakarta Tech Park")
                        .setCity("Jakarta")
                        .setState("Jakarta")
                        .setCountry("Indonesia")
                        .setCreatedOn(OffsetDateTime.now())
                        .setCreatedBy(UUID.randomUUID())
                )
                .setCreatedOn(OffsetDateTime.now())
                .setCreatedBy(UUID.randomUUID())
                .setTags(List.of(new Tag().setName("Java")));

        UUID eventId = eventRepository.save(event).getId();

        Optional<Event> eventOptional = eventRepository.findById(eventId);
        Assertions.assertTrue(eventOptional.isPresent());
        Assertions.assertEquals(eventOptional.get(), event);
    }

    @Test
    public void testGetEvents() {
        Event event = new Event()
                .setName("Intro to Java")
                .setDetail("Introduction about Java concepts")
                .setStart(OffsetDateTime.now())
                .setEnd(OffsetDateTime.now().plusHours(2))
                .setOnline(Boolean.TRUE)
                .setEventLink("http://meet.google.com/abc-defg-hij")
                .setLocation(new Location()
                        .setLatitude("-6.2295695")
                        .setLongitude("106.747117")
                        .setName("Jakarta Tech Park")
                        .setAddress("Jakarta Tech Park")
                        .setStreet("Jakarta Tech Park")
                        .setLocality("Jakarta Tech Park")
                        .setCity("Jakarta")
                        .setState("Jakarta")
                        .setCountry("Indonesia")
                        .setCreatedOn(OffsetDateTime.now())
                        .setCreatedBy(UUID.randomUUID())
                )
                .setCreatedOn(OffsetDateTime.now())
                .setCreatedBy(UUID.randomUUID())
                .setTags(List.of(new Tag().setName("Java")));

        Event result = eventRepository.save(event);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(event, result);
    }

    @Test
    public void testGetEventsByInvalidId() {
        Optional<Event> eventOptional = eventRepository.findById(UUID.randomUUID());
        Assertions.assertThrows(NoSuchElementException.class, eventOptional::get);
    }

    @Test
    public void testUpdateEvents() {
        Event event = new Event()
                .setName("Intro to Java")
                .setDetail("Introduction about Java concepts")
                .setStart(OffsetDateTime.now())
                .setEnd(OffsetDateTime.now().plusHours(2))
                .setOnline(Boolean.TRUE)
                .setEventLink("http://meet.google.com/abc-defg-hij")
                .setLocation(new Location()
                        .setLatitude("-6.2295695")
                        .setLongitude("106.747117")
                        .setName("Jakarta Tech Park")
                        .setAddress("Jakarta Tech Park")
                        .setStreet("Jakarta Tech Park")
                        .setLocality("Jakarta Tech Park")
                        .setCity("Jakarta")
                        .setState("Jakarta")
                        .setCountry("Indonesia")
                        .setCreatedOn(OffsetDateTime.now())
                        .setCreatedBy(UUID.randomUUID())
                )
                .setCreatedOn(OffsetDateTime.now())
                .setCreatedBy(UUID.randomUUID())
                .setTags(List.of(new Tag().setName("Java")));

        Event result = eventRepository.save(event);

        Event updatedEvent = eventRepository.findById(result.getId()).get().setEnd(OffsetDateTime.now().plusHours(3))
                .setUpdatedBy(result.getCreatedBy())
                .setUpdatedOn(OffsetDateTime.now());

        Event updatedEventResult = eventRepository.save(updatedEvent);

        Assertions.assertNotNull(updatedEventResult);
        Assertions.assertEquals(updatedEvent, updatedEventResult);
    }


}
