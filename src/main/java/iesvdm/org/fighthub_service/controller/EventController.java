package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Event;
import iesvdm.org.fighthub_service.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping(value = {"", "/"})
    public List<Event> getEvents() {
        log.info("EventController: getEvents");
        return eventService.getEvents();
    }
    @GetMapping(value = {"/{id}"})
    public Event getEvent(@PathVariable Long id) {
        log.info("EventController: getEvent - id: " + id);
        return eventService.getEvent(id);
    }
    @PostMapping(value = {"", "/"})
    public Event saveEvent(@RequestBody Event event) {
        log.info("EventController: saveEvent - id: " + event.getId());
        return eventService.saveEvent(event);
    }
    @PutMapping(value = {"/{id}"})
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        log.info("EventController: updateEvent - id: " + id);
        return eventService.updateEvent(id, event);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteEvent(@PathVariable Long id) {
        log.info("EventController: deleteEvent - id: " + id);
        eventService.deleteEvent(id);
    }
}
