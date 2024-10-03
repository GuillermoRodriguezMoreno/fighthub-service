package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.EventRepository;
import iesvdm.org.fighthub_service.schema.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Event.class));
    }
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent(Long id, Event event) {
        Event eventToUpdate = this.getEvent(id);
        BeanUtils.copyProperties(event, eventToUpdate, "id");
        return eventRepository.save(eventToUpdate);
    }
    public void deleteEvent(Long id) {
        Event eventToDelete = this.getEvent(id);
        eventRepository.delete(eventToDelete);
    }
}
